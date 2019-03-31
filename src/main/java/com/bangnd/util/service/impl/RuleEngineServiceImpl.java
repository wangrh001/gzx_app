package com.bangnd.util.service.impl;

import com.bangnd.util.entity.CalcFormula;
import com.bangnd.util.repository.CalcFormulaRepository;
import com.bangnd.util.service.ParamEngineService;
import com.bangnd.util.service.RuleEngineService;
import com.sun.deploy.appcontext.AppContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.interfaceName;

@Service
public class RuleEngineServiceImpl implements RuleEngineService {
    @Autowired
    CalcFormulaRepository calcFormulaRepository;
    @Autowired
    ParamEngineService paramEngineService;
    @Autowired
    ApplicationContext ctx;

    @Override
    public BigDecimal calc(long orderId, int type) {
        BigDecimal result = new BigDecimal(0);
        try {
            List<CalcFormula> calcFormulas = calcFormulaRepository.findAllByType(type);
            if(calcFormulas!=null&&calcFormulas.size()>0){
                Class clazz = Class.forName("com.bangnd.util.service.impl.ParamEngineServiceImpl");
                for(CalcFormula calcFormula:calcFormulas){
                    Expression expression = AviatorEvaluator.compile(calcFormula.getExpression());
                    List<String> params=expression.getVariableNames();
                    Map<String, Object> env = new HashMap<String, Object>();
                    if(params!=null && params.size()>0){
                        for (String param:params){
                            //注意，这里不能自己newInstance，这样new出的bean和spring没有关系，无法拿到他内部使用的bean，需要从Spring容器中获取bean
                            //Object obj = clazz.newInstance();

                            //从ApplicationContext,获取这个对象
                            Object obj=ctx.getBean(clazz);
                            String methodName=paramEngineService.getMathodName(param);
                            System.out.println("methodName="+methodName);
                            env.put(param,(clazz.getMethod(methodName,new Class[]{long.class})).invoke(obj,new Object[]{orderId}));
                        }
                    }
                    Object obj = (Object)expression.execute(env);
                    if(obj instanceof Long){
                        Long objLong=(Long)obj;
                        System.out.println(" Long  obj="+objLong);
                        result=result.add(new BigDecimal(objLong));
                    }else if(obj instanceof Double){
                        Double objDouble = (Double)obj;
                        System.out.println(" Long  obj="+objDouble);
                        result=result.add(new BigDecimal(objDouble));
                    }
                    System.out.println(calcFormula.getExpression()+" result="+result);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2){
            e2.printStackTrace();
        }catch (Exception e3){
            e3.printStackTrace();
        }
        return result;
    }
}
