package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.service.ParaCalculation;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ParaCalculationImpl {

    public static void main(String[] args) {
//        String expression = "date1==date2?100:200";
//        Date date1 = new Date();
//        Calendar c = Calendar.getInstance();
//        c.setTime(date1);
//        c.add(Calendar.DATE,1);
//        Date date2= c.getTime();
//
//        Expression compiledExp = AviatorEvaluator.compile(expression);
//        Map<String, Object> env = new HashMap<String, Object>();
//
//        env.put("date1", date1);
//        env.put("date2", date2);
////        env.put("b", 45);
////        env.put("c", -199.100);
////        env.put("amount",33);
//        Long result = (Long)compiledExp.execute(env);
//        System.out.println(result);
//        System.out.println("Date="+new Date().getTime()+";");
//        for(int i=0;i<20;i++){
//            String ex="date1==date2";
//            Date date=new Date();
//            Calendar c =Calendar.getInstance();
//            c.setTime(date);
//            c.add(Calendar.DATE,1);
//            Date date1=date;
//            Date date2=c.getTime();
//            String exp="(area==4||area==5)&&(usingDateAdd1==applyDate)&&amount<=800&&(endDate==usingDateAdd10)?0.8:-0.1";
//            Double result = (Double)AviatorEvaluator.exec(exp,4,date2,date2,400,date1,date1);
////        String date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(date);
////        String date2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(c.getTime());
////        Boolean result = (Boolean)AviatorEvaluator.exec(ex,date1,date2);
////        String expression="(area=4||area=5)&&(usingDate-applyDate=1)&&amount<=800&&(endDate-usingDate=10)?0.8:-0.1"
////        Long result = (Long)AviatorEvaluator.exec(expression,4,1,-199.100);
//            System.out.println("Date="+new Date()+";"+result);
//        }
//        System.out.println("Date="+new Date().getTime()+";");

        Atest atest = new Atest();
        B b = new B();
        BigDecimal c = new BigDecimal(0);
        c = atest.getA();
        b.setB(c);
        System.out.println(b.getB());


    }
}
