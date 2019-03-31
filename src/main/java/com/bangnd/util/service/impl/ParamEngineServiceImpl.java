package com.bangnd.util.service.impl;

import com.bangnd.cbs.entity.CustMortgage;
import com.bangnd.cbs.entity.Customer;
import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.service.CustMortgageService;
import com.bangnd.cbs.service.CustomerService;
import com.bangnd.cbs.service.OrderService;
import com.bangnd.finance.entity.Payment;
import com.bangnd.finance.service.PaymentPayStateService;
import com.bangnd.finance.service.PaymentService;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.entity.PerformanceCommission;
import com.bangnd.sales.service.AgentService;
import com.bangnd.sales.service.GroupService;
import com.bangnd.sales.service.PerformanceCommissionService;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.date.DateUtil;
import com.bangnd.util.service.ParamEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ParamEngineServiceImpl implements ParamEngineService {
    @Autowired
    OrderService orderService;
    @Autowired
    CustMortgageService custMortgageService;
    @Autowired
    CustomerService customerService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    AgentService agentService;
    @Autowired
    GroupService groupService;
    @Autowired
    PerformanceCommissionService performanceCommissionService;

    @Override
    public String getMathodName(String param) {
        return "get"+(new StringBuilder()).append(Character.toUpperCase(param.charAt(0))).append(param.substring(1)).toString();
    }

    /**
     *
     * @return
     */
    public Integer getOrderArea(long orderId){
        Integer orderArea=0;
        List<Customer> customerList = customerService.findCustomerByOrderId(orderId);
        if(customerList!=null&&customerList.size()>0){
            for(Customer customer:customerList){
                CustMortgage custMortgages = custMortgageService.findMortgageByCustomerId(customer.getId());
                //只要有一个远郊的抵押物，该单子就按照远郊进行处理
                if(custMortgages.getEstateArea()==4){
                    orderArea=4;
                    break ;
                }else orderArea=custMortgages.getEstateArea();
            }
        }
        System.out.println("orderArea="+orderArea);
        return orderArea;
    }

    /**
     *
     * @param orderId
     * @return：
     */
    public String getApplyDateAdd1Day(long orderId){
        Order order = orderService.findOrderById(orderId);
        Calendar calander= Calendar.getInstance();
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        if(order!=null){
            calander.setTime(order.getApplyTime());
            calander.add(Calendar.DATE,1);
        }
        //加一天，只比较年月日
        System.out.println("format2.format(calander.getTime())="+format2.format(calander.getTime()));
        return format2.format(calander.getTime());
    }

    /**
     *
     * @param orderId
     * @return：
     */
    public String getApplyDateAdd2Day(long orderId){
        Order order = orderService.findOrderById(orderId);
        Calendar calander= Calendar.getInstance();
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        if(order!=null){
            calander.setTime(order.getApplyTime());
            calander.add(Calendar.DATE,2);
        }
        //加两天，只比较年月日
        System.out.println("calander.getTime())="+calander.getTime());
        return format2.format(calander.getTime());
    }

    public String getDemandDate(long orderId){
        Order order = orderService.findOrderById(orderId);
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        if(order!=null){
            System.out.println("format2.format(order.getDemandDate())="+format2.format(order.getDemandDate()));
            return format2.format(order.getDemandDate());
        }
        return "";
    }


    public BigDecimal getAmount(long orderId){
        Order order = orderService.findOrderById(orderId);
        if(order!=null){
            System.out.println("order.getDemandAmount()="+order.getDemandAmount());
            return order.getDemandAmount();
        }
        return null;
    }

    public Double getUsing10DaysNum(long orderId){
        Order order = orderService.findOrderById(orderId);
        float daynum=0;
        Double days10NUm=0.0;
        if(order!=null) {
            switch (order.getPeriodType()) {
                case ConstantCfg.DAY:
                    daynum = (float) 1 * order.getPeriodNum();
                    if(daynum<=3){
                        days10NUm=0.0;
                    }else
                        days10NUm=Math.ceil(daynum/10);
                    break;
                case ConstantCfg.THREEDAY:
                    daynum = (float)3 * order.getPeriodNum();
                    if(daynum<=3){
                        days10NUm=0.0;
                    }else
                        days10NUm=Math.ceil(daynum/10);
                    break;
                case ConstantCfg.TENDAY:
                    daynum = (float)10 * order.getPeriodNum();
                    days10NUm=Math.ceil(daynum/10);
                    break;
            }
        }
        System.out.println("days10NUm="+days10NUm);
        return days10NUm;
    }

    public Double getUsing3DaysNum(long orderId){
        Order order = orderService.findOrderById(orderId);
        int daynum=0;
        Double days3NUm=0.0;
        if(order!=null) {
            switch (order.getPeriodType()) {
                case ConstantCfg.DAY:
                    daynum = 1 * order.getPeriodNum();
                    break;
                case ConstantCfg.THREEDAY:
                    daynum = 3 * order.getPeriodNum();
                    break;
                case ConstantCfg.TENDAY:
                    daynum = 10 * order.getPeriodNum();
                    break;
            }
        }
        if(daynum<=3){
            days3NUm=1.0;
        }else{
            if(daynum%10<3){
                days3NUm=1.0;
            }else {
                days3NUm=0.0;
            }
        }
        System.out.println("days3NUm="+days3NUm);
        return days3NUm;
    }

    public Integer getNextOrg(long orderId){
        Order order = orderService.findOrderById(orderId);
        if(order!=null){
            System.out.println("order.getNextOrgType()="+order.getNextOrgType());
            return order.getNextOrgType();
        }
        return 0;
    }

    public Integer getBusiType(long orderId){
        Order order = orderService.findOrderById(orderId);
        if(order!=null){
            System.out.println("order.getBusinessType()="+order.getBusinessType());
            return order.getBusinessType();
        }
        return 0;
    }

    public Integer getMortgageNum1(long orderId){
        List<Customer> customerList = customerService.findCustomerByOrderId(orderId);
        Integer num=0;
        if(customerList!=null&&customerList.size()>0){
            for(Customer customer:customerList){
                CustMortgage custMortgage = custMortgageService.findMortgageByCustomerId(customer.getId());
                if(custMortgage.getMortgageCount()==1){
                    num=num+1;
                }
            }
        }
        System.out.println("num1="+num);
        return num;
    }

    public Integer getMortgageNum2(long orderId){
        List<Customer> customerList = customerService.findCustomerByOrderId(orderId);
        Integer num=0;
        if(customerList!=null&&customerList.size()>0){
            for(Customer customer:customerList){
                CustMortgage custMortgage = custMortgageService.findMortgageByCustomerId(customer.getId());
                if(custMortgage.getMortgageCount()==2){
                    num=num+1;
                }
            }
        }
        System.out.println("num2="+num);
        return num;
    }
    //获得该订单的业务员，该月的所有利息之和
    public BigDecimal getMonthInterest(long orderId){
        BigDecimal sumInterest=new BigDecimal(0);
        Order order = orderService.findOrderById(orderId);
        if(order!=null){
            long salesId=order.getSalerId();
            Date monthStart = DateUtil.getMonthStart(order.getSignDate());
            Date monthEnd = DateUtil.getMonthStart(order.getSignDate());
            List<Order> orders = orderService.findOrderBySalesId(salesId,monthStart,monthEnd);
            if(orders!=null&&orders.size()>0){
                for(Order order1:orders){
                    Payment payment = paymentService.getPaymentByOrderIdAndFeeType(order1.getId(),ConstantCfg.FEE_TYPE_INTEREST);
                    if(payment!=null){
                        BigDecimal interest = payment.getAmount();
                        sumInterest=sumInterest.add(interest);
                    }

                }
            }
        }
        return sumInterest;
    }
    //获得该订单的利息
    public BigDecimal getOrderInterest(long orderId){
        BigDecimal interest = new BigDecimal(0);
        Payment payment = paymentService.getPaymentByOrderIdAndFeeType(orderId,ConstantCfg.FEE_TYPE_INTEREST);
        if(payment!=null){
            interest=payment.getAmount();
        }
        return interest;
    }

    public BigDecimal getGroupInterest(long orderId){
        BigDecimal groupInterest = new BigDecimal(0);
        Order order = orderService.findOrderById(orderId);
        String yearMonth=DateUtil.getYearMonth(order.getSignDate());
        if(order!=null){
            Agent agent = agentService.getAgentById(order.getSalerId());
            if(agent !=null){
                List<Agent> agents = agentService.getAgentByGroupId(agent.getGroupId());
                if(agents!=null && agents.size()>0){
                    for(Agent agent1:agents){
                        PerformanceCommission pc = performanceCommissionService.getPerformanceCommissionByAgentIdAndMonth(agent1.getId(),yearMonth);
                        if(pc!=null){
                            groupInterest=groupInterest.add(pc.getInterest());
                        }
                    }
                }
            }
        }
        return groupInterest;
    }

    public static void main(String[] args){
        int a = 14;
        System.out.println(Math.ceil(a/10));

    }
}
