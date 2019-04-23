package com.bangnd.cbs.service.impl;

import com.bangnd.batch.jobs.client.AlibabaAiService;
import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.entity.OrderDocument;
import com.bangnd.cbs.form.OrderSearchForm;
import com.bangnd.cbs.repository.OrderRepository;
import com.bangnd.cbs.service.*;
import com.bangnd.finance.entity.Payment;
import com.bangnd.finance.service.PaymentService;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.entity.Group;
import com.bangnd.sales.entity.PerformanceCommDetail;
import com.bangnd.sales.repository.AgentRepository;
import com.bangnd.sales.service.AgentService;
import com.bangnd.sales.service.GroupService;
import com.bangnd.sales.service.PerformanceCommDetailService;
import com.bangnd.sales.service.PerformanceCommissionService;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.entity.WorkFlow;
import com.bangnd.util.exception.AppException;
import com.bangnd.util.service.FormatInfoObjService;
import com.bangnd.util.service.RuleEngineService;
import com.bangnd.util.service.WorkFlowService;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    AgentRepository agentRepository;
    @Autowired
    WorkFlowService workFlowService;
    @Autowired
    OrderPoolService orderPoolService;
    @Autowired
    OrderLogService orderLogService;
    @Autowired
    DocHandlerService docHandlerService;
    @Autowired
    OrderDocService orderDocService;
    @Autowired
    RuleEngineService ruleEngineService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    PerformanceCommDetailService performanceCommDetailService;
    @Autowired
    PerformanceCommissionService performanceCommissionService;
    @Autowired
    GroupService groupService;
    @Autowired
    AgentService agentService;
    @Autowired
    OrderDocTypeService orderDocTypeService;
    @Autowired
    FormatInfoObjService formatInfoObjService;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }


    public Page<Order> getOrderList(Integer pageNum, int size, List<Long> orderList, OrderSearchForm orderSearchForm) {
        Assert.notNull(orderSearchForm);
        Specification specification = new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();

                setPredicate(root, predicates, orderSearchForm, cb);

                //状态只能显示该角色下可以查看的状态
                CriteriaBuilder.In<Long> in = cb.in(root.get("id"));
                for (Long id : orderList) {
                    in.value(id);
                }
                predicates.add(in);

                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };

        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<Order> qyPage = this.orderRepository.findAll(specification, pageable);
        return qyPage;
    }

    @Override
    public Page<Order> getAllOrderList(Integer pageNum, int size, OrderSearchForm orderSearchForm) {
        Assert.notNull(orderSearchForm);
        Specification specification = new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();

                setPredicate(root, predicates, orderSearchForm, cb);

                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };

        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<Order> qyPage = this.orderRepository.findAll(specification, pageable);
        return qyPage;
    }

    @Override
    public List<Order> findOrderBySalesId(long salesId, Date startDate, Date endDate) {
        return this.orderRepository.findAllBySalsesId(salesId, startDate, endDate);
    }

    private void setPredicate(Root<Order> root, List<Predicate> predicates, OrderSearchForm orderSearchForm, CriteriaBuilder cb) {
        if (orderSearchForm.getApplicantName() != null && !"".equals(orderSearchForm.getApplicantName())) {
            System.out.println("applicantName=" + orderSearchForm.getApplicantName());
            predicates.add(cb.like(root.get("applicantName").as(String.class), "%" + orderSearchForm.getApplicantName() + "%"));
        }

        if (orderSearchForm.getOrderState() != null && !"".equals(orderSearchForm.getOrderState())) {
            System.out.println("orderState=" + orderSearchForm.getOrderState());
            if ("0".equals(orderSearchForm.getOrderState())) {
                predicates.add(cb.notEqual(root.get("orderState").as(Integer.class), new Integer(orderSearchForm.getOrderState())));
            } else {
                predicates.add(cb.equal(root.get("orderState").as(Integer.class), new Integer(orderSearchForm.getOrderState())));
            }
        } else {
            predicates.add(cb.notEqual(root.get("orderState").as(Integer.class), new Integer(ConstantCfg.ORDER_STATE_127)));
        }

        predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
        if (orderSearchForm.getCellPhone() != null && !"".equals(orderSearchForm.getCellPhone())) {
            System.out.println("cellPhone=" + orderSearchForm.getCellPhone());
            predicates.add(cb.equal(root.get("cellPhone"), orderSearchForm.getCellPhone()));
        }
        if (orderSearchForm.getBusinessType() != null && !"".equals(orderSearchForm.getBusinessType())) {
            System.out.println("businessType=" + orderSearchForm.getBusinessType());
            if ("0".equals(orderSearchForm.getBusinessType())) {
                predicates.add(cb.notEqual(root.get("businessType"), orderSearchForm.getBusinessType()));
            } else {
                predicates.add(cb.equal(root.get("businessType"), orderSearchForm.getBusinessType()));
            }
        }

        if (!"".equals(orderSearchForm.getStartDate()) && !"".equals(orderSearchForm.getEndDate())
                && orderSearchForm.getStartDate() != null && orderSearchForm.getEndDate() != null) {
            System.out.println("start_time=" + orderSearchForm.getStartDate());
            System.out.println("end_time=" + orderSearchForm.getEndDate());
            Date startDate = null;
            Date endDate = null;
            Calendar c = Calendar.getInstance();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                startDate = sdf.parse(orderSearchForm.getStartDate());
                endDate = sdf.parse(orderSearchForm.getEndDate());
                c.setTime(endDate);
                c.add(Calendar.DAY_OF_MONTH, 1);
            } catch (Exception e) {
                e.getMessage();
            }
            predicates.add(cb.between(root.get("applyTime").as(Date.class), startDate, c.getTime()));
        }
    }

    @Override
    public Order findOrderById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Order order = orderRepository.findById(id.longValue());
        order.setState(100);
        orderRepository.save(order);
    }

    @Override
    public void flush(Order order) {
        orderRepository.saveAndFlush(order);
    }

    @Transactional
    @Override
    public void saveClientApprove(String approveId, OapiProcessinstanceGetResponse response) throws Exception {

        if (response.getErrcode() != 0) {
            throw new AppException("请检查钉钉服务异常，返回码错误！");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Order order = orderRepository.getOrderByApproveId(approveId);
        Integer buttonId = 0;
        int approveOrderState = 0;

        //如果订单已经存在
        if (order != null && approveId.equals(order.getApproveId())) {
            //审批已经完成，并且结果是同意或者不同意，但是系统中还是初录入，才需要同步状态，其他都不需要
            if ((ConstantCfg.DD_RESPONSE_agree.equals(response.getProcessInstance().getResult())
                    || ConstantCfg.DD_RESPONSE_refuse.equals(response.getProcessInstance().getResult()))
                    && order.getOrderState() == ConstantCfg.ORDER_STATE_102
                    && ConstantCfg.DD_RESPONSE_COMPLETED.equals(response.getProcessInstance().getStatus())) {
                if (ConstantCfg.DD_RESPONSE_agree.equals(response.getProcessInstance().getResult())) {
                    approveOrderState = ConstantCfg.ORDER_STATE_104;
                    buttonId = ConstantCfg.BUTTON_ID_74;
                } else if (ConstantCfg.DD_RESPONSE_refuse.equals(response.getProcessInstance().getResult())) {
                    approveOrderState = ConstantCfg.ORDER_STATE_103;
                    buttonId = ConstantCfg.BUTTON_ID_73;
                }
                order.setOrderState(approveOrderState);
                order.setUpdateTime(new Date());
                order.setUpdator(0);
                Agent agent = agentRepository.getAgentByDdUserName(response.getProcessInstance().getOriginatorUserid());
                orderRepository.save(order);
                WorkFlow workFlow = workFlowService.getNextWorkFlowBy(ConstantCfg.ORDER_STATE_102, buttonId, order.getBusinessType());
                orderPoolService.intoPool(order.getId(), workFlow.getBeforeState(), workFlow.getAfterState(), agent.getUserId(), order.getBusinessType());
                orderLogService.recordLog(order.getId(), agent.getUserId(), buttonId);
            }
        } else {
            //第一次提交审批
            BigDecimal demandAmount = new BigDecimal(0);
            Date demandDate = new Date();
            int daysUsing=0;
            String certiPicUrls = "";
            String housePicUrls = "";

            List<OapiProcessinstanceGetResponse.FormComponentValueVo> vos = response.getProcessInstance().getFormComponentValues();
            for (OapiProcessinstanceGetResponse.FormComponentValueVo vo : vos) {
                if (ConstantCfg.DD_RESPONSE_AMOUNTNAME.equals(vo.getName())) {
                    demandAmount = new BigDecimal(vo.getValue());
                } else if (ConstantCfg.DD_RESPONSE_DATEINPUTNAME.equals(vo.getName())) {
                    demandDate = sdf.parse(vo.getValue());
                }else if(ConstantCfg.DD_RESPONSE_DAYS_USING.equals(vo.getName())){
                    daysUsing=Integer.valueOf(vo.getValue());
                } else if (ConstantCfg.DD_RESPONSE_CERTI_PIC.equals(vo.getName())) {
                    certiPicUrls = vo.getValue();
                } else if(ConstantCfg.DD_RESPONSE_HOUSE_PIC.equals(vo.getName())){
                    housePicUrls = vo.getValue();
                }
            }
            Order newOrder = new Order();
            newOrder.setOrderState(ConstantCfg.ORDER_STATE_102);
            newOrder.setDemandAmount(demandAmount);
            newOrder.setDemandDate(demandDate);
            newOrder.setPeriodType(ConstantCfg.PERIOD_TYPE_BY_DAY);
            newOrder.setPeriodNum(daysUsing);
            newOrder.setBusinessType(ConstantCfg.BUSI_TYPE_2);
            newOrder.setApplyTime(new Date());
            newOrder.setCreator(0);
            newOrder.setCreateTime(new Date());
            newOrder.setApproveId(approveId);
            Agent agent = agentRepository.getAgentByDdUserName(response.getProcessInstance().getOriginatorUserid());
            if (agent == null) {
                System.out.println(response.getProcessInstance().getOriginatorUserid());
                throw new AppException(response.getProcessInstance().getOriginatorUserid() + ":这个出单的钉钉用户还没有配置内部业务员，请尽快配置");
            }
            newOrder.setSalerId(agent.getId());
            orderRepository.save(newOrder);

            //存储身份信息
            savePics(certiPicUrls,ConstantCfg.DOC_TYPE_1,newOrder.getId());
            //存储房产证信息
            savePics(housePicUrls,ConstantCfg.DOC_TYPE_6,newOrder.getId());

            buttonId = ConstantCfg.BUTTON_ID_72;
            orderPoolService.intoPool(newOrder.getId(), 0, newOrder.getOrderState(), agent.getUserId(), newOrder.getBusinessType());
            orderLogService.recordLog(newOrder.getId(), agent.getUserId(), buttonId);
        }

        System.out.println(approveId + " have been inserted db!");
    }

    private void savePics(String picUrls,int docType,long orderId){
        //将上传到钉钉上的图片下载下来，并存储到相应位置
        String typeName = (orderDocTypeService.getOrderDocTypeById(docType)).getChName();
        Map<String, String> fileNameMapping = docHandlerService.storageFilesFromUrls(picUrls,typeName, Long.valueOf(orderId).toString());
        //将这些文件的路径保存到数据库中
        for (String uuidName : fileNameMapping.keySet()) {
            OrderDocument orderDocument = new OrderDocument();
            orderDocument.setOrderId(orderId);
            orderDocument.setOriginaName(fileNameMapping.get(uuidName));
            orderDocument.setOriginalFilePath(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId +"/"+typeName+ "/" + fileNameMapping.get(uuidName));
            orderDocument.setUUIDName(uuidName);
            orderDocument.setUUIDNamedFilePath(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId +"/"+typeName + "/" + uuidName);
            orderDocument.setCondenseNamePath(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId +"/"+typeName + "/" + uuidName);
            orderDocument.setState(ConstantCfg.PUBLIC_VALID_STATE);
            orderDocument.setCreator(0);
            orderDocument.setCreateTime(new Date());
            orderDocument.setDocType(docType);
            orderDocService.save(orderDocument);

            //调用alibaba的ai服务，格式化这个图片
            AlibabaAiService alibabaAiService= new AlibabaAiService();
            if(docType==ConstantCfg.DOC_TYPE_1){
                String certiFormatString = alibabaAiService.certiCodeOCR(orderDocument.getOriginalFilePath());
                formatInfoObjService.saveFormatInfo(certiFormatString,orderId,ConstantCfg.DOC_TYPE_1);
            }else if(docType==ConstantCfg.DOC_TYPE_6){
                String houseFormatString = alibabaAiService.houseOCR(orderDocument.getOriginalFilePath());
                //存储房产证信息
                formatInfoObjService.saveFormatInfo(houseFormatString,orderId,ConstantCfg.DOC_TYPE_6);
            }
        }
    }

    @Override
    public void halderFeeByDiffStep(int afterState, Order order,long updatorId) {
        //根据不同的状态节点，写入费用
        if (afterState == ConstantCfg.ORDER_STATE_108) {
            BigDecimal downFee = ruleEngineService.calc(order.getId(), ConstantCfg.CALC_TYPE_2);
            paymentService.save(setPaymentAttr(order.getId(), downFee, updatorId, ConstantCfg.FEE_TYPE_DOWN));
        } else if (afterState == ConstantCfg.ORDER_STATE_116) {
            BigDecimal interestFee = ruleEngineService.calc(order.getId(), ConstantCfg.CALC_TYPE_1);
            paymentService.save(setPaymentAttr(order.getId(), interestFee, updatorId, ConstantCfg.FEE_TYPE_INTEREST));
            BigDecimal lawFee = ruleEngineService.calc(order.getId(), ConstantCfg.CALC_TYPE_3);
            paymentService.save(setPaymentAttr(order.getId(), lawFee, updatorId, ConstantCfg.FEE_TYPE_LAWFEE));
        } else if (afterState == ConstantCfg.ORDER_STATE_119) {
            paymentService.save(setPaymentAttr(order.getId(), order.getDemandAmount(), updatorId, ConstantCfg.FEE_TYPE_OUTAMOUNT));
        } else if (afterState == ConstantCfg.ORDER_STATE_124) {
            Payment payment = setPaymentAttr(order.getId(), order.getDemandAmount(), updatorId, ConstantCfg.FEE_TYPE_INAMOUNT);
            payment.setInOut(ConstantCfg.IN_OUT_2);
            paymentService.save(payment);
        } else if (afterState == ConstantCfg.ORDER_STATE_127) {
            Payment payment = paymentService.getPaymentByOrderIdAndFeeType(order.getId(), ConstantCfg.FEE_TYPE_INTEREST);
            if (payment != null) {
                Agent agent = agentService.getAgentById(order.getSalerId());
                //如果是外勤，需要逐笔计算佣金，并写入费用
                if (agent != null && agent.getChannelType() == ConstantCfg.CHANNEL_TYPE_2) {
                    BigDecimal commission1 = ruleEngineService.calc(order.getId(), ConstantCfg.CALC_TYPE_10);
                    Payment payment1 = setPaymentAttr(order.getId(), commission1, updatorId, ConstantCfg.FEE_TYPE_COMMISSION);
                    payment1.setInOut(ConstantCfg.IN_OUT_2);
                    paymentService.save(payment1);
                    BigDecimal interest = payment.getAmount();
                    PerformanceCommDetail performanceCommDetail = setPerformanceCommDetail(order.getId(), order.getDemandAmount(), interest);
                    performanceCommDetail.setSalerId(order.getSalerId());
                    performanceCommDetail.setMinCommission(commission1);
                    performanceCommDetail.setMaxCommission(commission1);
                    performanceCommDetail.setCommission(commission1);
                    performanceCommDetailService.save(performanceCommDetail);
                } else if (agent != null && agent.getChannelType() == ConstantCfg.CHANNEL_TYPE_1) {
                    BigDecimal minCommission = ruleEngineService.calc(order.getId(), ConstantCfg.CALC_TYPE_8);
                    BigDecimal commission = ruleEngineService.calc(order.getId(), ConstantCfg.CALC_TYPE_5);
                    BigDecimal maxCommission = ruleEngineService.calc(order.getId(), ConstantCfg.CALC_TYPE_9);
                    BigDecimal interest = payment.getAmount();
                    PerformanceCommDetail performanceCommDetail = setPerformanceCommDetail(order.getId(), order.getDemandAmount(), interest);
                    performanceCommDetail.setSalerId(order.getSalerId());
                    performanceCommDetail.setMinCommission(minCommission);
                    performanceCommDetail.setMaxCommission(maxCommission);
                    performanceCommDetail.setCommission(commission);
                    performanceCommDetailService.save(performanceCommDetail);
                    //回算历史所有佣金明细
                    performanceCommDetailService.reCalc(order.getId());
                    performanceCommissionService.calcMonthCommission(agent.getId(), order.getSignDate());
                }
                //计算经理的提成：
                if (agent != null) {
                    Group group = groupService.getGroupById(agent.getGroupId());
                    if (group != null) {
                        //拿到这个团队的负责人salerId
                        Agent agent1 = agentService.getAgentByEmployeeId(group.getEmployeeId());
                        if (agent1 != null) {
                            BigDecimal minCommission = ruleEngineService.calc(order.getId(), ConstantCfg.CALC_TYPE_12);
                            BigDecimal commission = ruleEngineService.calc(order.getId(), ConstantCfg.CALC_TYPE_7);
                            BigDecimal maxCommission = ruleEngineService.calc(order.getId(), ConstantCfg.CALC_TYPE_11);
                            BigDecimal interest = payment.getAmount();
                            PerformanceCommDetail performanceCommDetail = setPerformanceCommDetail(order.getId(), order.getDemandAmount(), interest);
                            performanceCommDetail.setSalerId(agent1.getId());
                            performanceCommDetail.setMinCommission(minCommission);
                            performanceCommDetail.setMaxCommission(maxCommission);
                            performanceCommDetail.setCommission(commission);
                            performanceCommDetailService.save(performanceCommDetail);
                            //暂时不回算：回算历史所有佣金明细
                            //performanceCommDetailService.reCalcManagerComm(agent1.getEmployeeId());
                            performanceCommissionService.calcMonthCommission(agent1.getId(), order.getSignDate());
                        }
                    }
                }
            }
        }
    }

    private Payment setPaymentAttr(long orderId, BigDecimal amount, long updatorId, int feeType) {
        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setRelatedId(0L);
        payment.setPayType(feeType);
        payment.setInOut(1);
        payment.setOffset(2);
        payment.setIfReal(2);
        payment.setState(1);
        payment.setCreator(Long.valueOf(updatorId).intValue());
        payment.setPayState(6);
        payment.setPayDate(new Date());
        return payment;
    }

    private PerformanceCommDetail setPerformanceCommDetail(long orderId, BigDecimal performance, BigDecimal interest) {
        PerformanceCommDetail performanceCommDetail = new PerformanceCommDetail();
        performanceCommDetail.setOrderId(orderId);
        performanceCommDetail.setPerformance(performance);
        performanceCommDetail.setInterest(interest);
        performanceCommDetail.setCreateTime(new Date());
        performanceCommDetail.setCreator(0);
        performanceCommDetail.setState(1);
        return performanceCommDetail;
    }
}
