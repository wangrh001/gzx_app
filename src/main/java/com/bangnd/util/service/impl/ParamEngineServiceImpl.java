package com.bangnd.util.service.impl;

import com.bangnd.bridgecbs.entity.BridgeOrder;
import com.bangnd.bridgecbs.service.BridgeOrderService;
import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.service.CustMortgageService;
import com.bangnd.cbs.service.CustomerService;
import com.bangnd.cbs.service.OrderService;
import com.bangnd.finance.entity.Payment;
import com.bangnd.finance.service.PaymentService;
import com.bangnd.hr.service.EmployeeService;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.entity.PerformanceCommission;
import com.bangnd.sales.service.AgentService;
import com.bangnd.sales.service.GroupService;
import com.bangnd.sales.service.PerformanceCommissionService;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.date.DateUtil;
import com.bangnd.util.entity.FormatInfoObject;
import com.bangnd.util.entity.ReminderLog;
import com.bangnd.util.service.FormatInfoObjService;
import com.bangnd.util.service.ParamEngineService;
import com.bangnd.util.service.ReminderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ParamEngineServiceImpl implements ParamEngineService {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustMortgageService custMortgageService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private AgentService agentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private PerformanceCommissionService performanceCommissionService;
    @Autowired
    private FormatInfoObjService formatInfoObjService;
    @Autowired
    private ReminderLogService reminderLogService;
    @Autowired
    private BridgeOrderService bridgeOrderService;


    @Override
    public String getMethodName(String param) {
        return "get" + (new StringBuilder()).append(Character.toUpperCase(param.charAt(0))).append(param.substring(1)).toString();
    }

    @Override
    public String getReminderMethodName(String param) {
        if (param != null && param.contains("Days") && (param.contains("Add") || param.contains("Minus"))) {
            return "getKeyTime";
        } else {
            return "get" + (new StringBuilder()).append(Character.toUpperCase(param.charAt(0))).append(param.substring(1)).toString();
        }
    }

    /**
     * @return
     */
//    public Integer getOrderArea(long orderId) {
//        Integer orderArea = 0;
//        List<BridgeCustomer> customerList = customerService.findCustomerByOrderId(orderId);
//        if (customerList != null && customerList.size() > 0) {
//            for (BridgeCustomer customer : customerList) {
//                CustMortgage custMortgages = custMortgageService.findMortgageByCustomerId(customer.getId());
//                //只要有一个远郊的抵押物，该单子就按照远郊进行处理
//                if (custMortgages.getEstateArea() == 4) {
//                    orderArea = 4;
//                    break;
//                } else orderArea = custMortgages.getEstateArea();
//            }
//        }
//        System.out.println("orderArea=" + orderArea);
//        return orderArea;
//    }
    public Integer getOrderArea(long orderId) {
        Integer orderArea = 0;
        FormatInfoObject formatInfoObject = formatInfoObjService.getFormatInfoObjByOrderId(orderId);
        if (formatInfoObject != null) {
            orderArea = formatInfoObject.getHouseArea();
        }
        System.out.println("orderArea=" + orderArea);
        return orderArea;
    }

    /**
     * @param orderId
     * @return：
     */
    public String getApplyDateAdd1Day(long orderId) {
        Order order = orderService.findOrderById(orderId);
        Calendar calander = Calendar.getInstance();
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        if (order != null) {
            calander.setTime(order.getApplyTime());
            calander.add(Calendar.DATE, 1);
        }
        //加一天，只比较年月日
        System.out.println("format2.format(calander.getTime())=" + format2.format(calander.getTime()));
        return format2.format(calander.getTime());
    }

    /**
     * @param orderId
     * @return：
     */
    public String getApplyDateAdd2Day(long orderId) {
        Order order = orderService.findOrderById(orderId);
        Calendar calander = Calendar.getInstance();
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        if (order != null) {
            calander.setTime(order.getApplyTime());
            calander.add(Calendar.DATE, 2);
        }
        //加两天，只比较年月日
        System.out.println("calander.getTime())=" + calander.getTime());
        return format2.format(calander.getTime());
    }

    public String getDemandDate(long orderId) {
        Order order = orderService.findOrderById(orderId);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        if (order != null) {
            System.out.println("format2.format(order.getDemandDate())=" + format2.format(order.getDemandDate()));
            return format2.format(order.getDemandDate());
        }
        return "";
    }


    public BigDecimal getAmount(long orderId) {
        Order order = orderService.findOrderById(orderId);
        if (order != null) {
            System.out.println("order.getDemandAmount()=" + order.getDemandAmount());
            return order.getDemandAmount();
        }
        return null;
    }

    public BigDecimal getSelfAmount(long orderId) {
        FormatInfoObject formatInfoObject = formatInfoObjService.getFormatInfoObjByOrderId(orderId);
        if (formatInfoObject != null) {
            System.out.println("formatInfoObject.getSelfAmount()" + formatInfoObject.getSelfAmount());
            return formatInfoObject.getSelfAmount();
        }
        return null;
    }

    public Double getUsing10DaysNum(long orderId) {
        FormatInfoObject formatInfoObject = formatInfoObjService.getFormatInfoObjByOrderId(orderId);
        float daynum = formatInfoObject.getCustomerFirstPayDays();
        Double days10NUm = 0.0;
        if (daynum <= 3) {
            days10NUm = 0.0;
        } else
            days10NUm = Math.ceil(daynum / 10);

        System.out.println("days10NUm=" + days10NUm);
        return days10NUm;
    }

    public Double getUsing3DaysNum(long orderId) {
        FormatInfoObject formatInfoObject = formatInfoObjService.getFormatInfoObjByOrderId(orderId);
        float daynum = formatInfoObject.getCustomerFirstPayDays();
        Double days3NUm = 0.0;
        if (daynum <= 3) {
            days3NUm = 1.0;
        } else {
            if (daynum % 10 < 3) {
                days3NUm = 1.0;
            } else {
                days3NUm = 0.0;
            }
        }
        System.out.println("days3NUm=" + days3NUm);
        return days3NUm;
    }

    public Integer getNextOrg(long orderId) {
        Order order = orderService.findOrderById(orderId);
        if (order != null) {
            System.out.println("order.getNextOrgType()=" + order.getNextOrgType());
            return order.getNextOrgType();
        }
        return 0;
    }

    public Integer getBusiType(long orderId) {
        Order order = orderService.findOrderById(orderId);
        if (order != null) {
            System.out.println("order.getBusinessType()=" + order.getBusinessType());
            return order.getBusinessType();
        }
        return 0;
    }

    public Integer getMortgageNum1(long orderId) {
        Integer num = 0;
        FormatInfoObject formatInfoObject = formatInfoObjService.getFormatInfoObjByOrderId(orderId);
        if (formatInfoObject != null) {
            if (formatInfoObject.getMortgageNum() == 1) {
                num = 1;
            }
        }
        System.out.println("num1=" + num);
        return num;
    }

    public Integer getMortgageNum2(long orderId) {
        Integer num = 0;
        FormatInfoObject formatInfoObject = formatInfoObjService.getFormatInfoObjByOrderId(orderId);
        if (formatInfoObject != null) {
            if (formatInfoObject.getMortgageNum() == 2) {
                num = 1;
            }
        }
        System.out.println("num2=" + num);
        return num;
    }

//    public Integer getMortgageNum1(long orderId) {
//        List<BridgeCustomer> customerList = customerService.findCustomerByOrderId(orderId);
//        Integer num = 0;
//        if (customerList != null && customerList.size() > 0) {
//            for (BridgeCustomer customer : customerList) {
//                CustMortgage custMortgage = custMortgageService.findMortgageByCustomerId(customer.getId());
//                if (custMortgage.getMortgageCount() == 1) {
//                    num = num + 1;
//                }
//            }
//        }
//        System.out.println("num1=" + num);
//        return num;
//    }
//
//    public Integer getMortgageNum2(long orderId) {
//        List<BridgeCustomer> customerList = customerService.findCustomerByOrderId(orderId);
//        Integer num = 0;
//        if (customerList != null && customerList.size() > 0) {
//            for (BridgeCustomer customer : customerList) {
//                CustMortgage custMortgage = custMortgageService.findMortgageByCustomerId(customer.getId());
//                if (custMortgage.getMortgageCount() == 2) {
//                    num = num + 1;
//                }
//            }
//        }
//        System.out.println("num2=" + num);
//        return num;
//    }

    //获得该订单的业务员，该月的所有利息之和
    public BigDecimal getMonthInterest(long orderId) {
        BigDecimal sumInterest = new BigDecimal(0);
        Order order = orderService.findOrderById(orderId);
        Date signDate = formatInfoObjService.getSignDate(orderId);
        if (order != null) {
            long salesId = order.getSalerId();
            Date monthStart = DateUtil.getMonthStart(signDate);
            Date monthEnd = DateUtil.getMonthStart(signDate);
            List<Order> orders = orderService.findOrderBySalesId(salesId, monthStart, monthEnd);
            if (orders != null && orders.size() > 0) {
                for (Order order1 : orders) {
                    Payment payment = paymentService.getPaymentByOrderIdAndFeeType(order1.getId(), ConstantCfg.FEE_TYPE_INTEREST);
                    if (payment != null) {
                        BigDecimal interest = payment.getAmount();
                        sumInterest = sumInterest.add(interest);
                    }
                }
            }
        }
        return sumInterest;
    }

    //获得该订单的利息
    public BigDecimal getOrderInterest(long orderId) {
        BigDecimal interest = new BigDecimal(0);
        Payment payment = paymentService.getPaymentByOrderIdAndFeeType(orderId, ConstantCfg.FEE_TYPE_INTEREST);
        if (payment != null) {
            interest = payment.getAmount();
        }
        return interest;
    }

    public BigDecimal getGroupInterest(long orderId) {
        BigDecimal groupInterest = new BigDecimal(0);
        Order order = orderService.findOrderById(orderId);
        Date signDate = formatInfoObjService.getSignDate(orderId);
        String yearMonth = DateUtil.getYearMonth(signDate);
        if (order != null) {
            Agent agent = agentService.getAgentById(order.getSalerId());
            if (agent != null) {
                List<Agent> agents = agentService.getAgentByGroupId(agent.getGroupId());
                if (agents != null && agents.size() > 0) {
                    for (Agent agent1 : agents) {
                        PerformanceCommission pc = performanceCommissionService.getPerformanceCommissionByAgentIdAndMonth(agent1.getId(), yearMonth);
                        if (pc != null) {
                            groupInterest = groupInterest.add(pc.getInterest());
                        }
                    }
                }
            }
        }
        return groupInterest;
    }

    /**
     * 获取机构的款项
     *
     * @param orderId
     * @return
     */
    public long getOrganAmount(long orderId) {
        FormatInfoObject formatInfoObject = formatInfoObjService.getFormatInfoObjByOrderId(orderId);
        if (formatInfoObject == null) {
            return 0;
        } else {
            return formatInfoObject.getOrganAmount().longValue();
        }
    }

    public long getPlanOrganAmount(long orderId) {
        BridgeOrder bridgeOrder = bridgeOrderService.getBridgeOrderById(orderId);
        if (bridgeOrder == null) {
            return 0;
        } else {
            if (bridgeOrder.getPlanOrganAmount() == null) {
                return 0;
            }
            return bridgeOrder.getPlanOrganAmount().longValue();
        }
    }

    public long getRealOrganAmount(long orderId) {
        BridgeOrder bridgeOrder = bridgeOrderService.getBridgeOrderById(orderId);
        if (bridgeOrder == null) {
            return 0;
        } else {
            if (bridgeOrder.getOrganAmount() == null) {
                return 0;
            }
            return bridgeOrder.getOrganAmount().longValue();
        }
    }

    /**
     * 下面这些都是提醒逻辑条件的参数
     *
     * @param
     * @param orderId
     * @return
     */
    public String getKeyTiming(String keyTime, String earlier, long orderId) throws Exception {
        FormatInfoObject formatInfoObject = formatInfoObjService.getFormatInfoObjByOrderId(orderId);
        if (formatInfoObject == null) {
            return null;
        }
        Method getMethod = formatInfoObject.getClass().getMethod("get" + Character.toUpperCase(keyTime.charAt(0)) + keyTime.substring(1));
        Date keyTiming = (Date) getMethod.invoke(formatInfoObject);
        if (keyTiming != null && !"".equals(keyTiming)) {
            Calendar calendar = Calendar.getInstance();
            System.out.println("keyTiming=" + keyTiming);
            calendar.setTime(keyTiming);
            calendar.add(Calendar.DATE, Long.valueOf(earlier).intValue());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
            return sdf.format(calendar.getTime());
        }
        return null;
    }

    public String getUnzipDocExpectedReceiveDateMinus3Days(long reminderId, long orderId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        FormatInfoObject formatInfoObject = formatInfoObjService.getFormatInfoObjByOrderId(orderId);
        if (formatInfoObject != null && formatInfoObject.getUnzipDocExpectedReceiveDate() != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(formatInfoObject.getUnzipDocExpectedReceiveDate());
            c.add(Calendar.DATE, -3);
            return sdf.format(c.getTime());
        }
        return null;
    }

    public String getLastReminderPlus1Day(long reminderId, long orderId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        ReminderLog reminderLog = reminderLogService.getLastReminderLogByOrderIdAndReminderId(reminderId, orderId);
        Calendar c = Calendar.getInstance();
        if (reminderLog != null) {
            c.setTime(reminderLog.getCreateTime());
            c.add(Calendar.DATE, 1);
            return sdf.format(c.getTime());
        } else {
            //即：如果是第一次，log表中没有记录，就设置一个10年
            c.setTime(new Date());
            c.add(Calendar.YEAR, -10);
            return sdf.format(c.getTime());
        }

    }

    public long getOrderState(long reminderId, long orderId) {
        Order order = orderService.findOrderById(orderId);
        return order.getOrderState();
    }

    public String getSysdate(long reminderId, long orderId) {
        Date sysdate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        return sdf.format(sysdate);
    }

    /**
     * 下面这些都是发送内容的参数
     *
     * @param
     */

    public String getReceiverName(String name, String orderId) {
        return name;
    }

    public String getOrderId(String name, String orderId) {
        return orderId;
    }

    public static void main(String[] args) {
        String a = "Cabced";
        System.out.println(a.substring(0));

    }
}
