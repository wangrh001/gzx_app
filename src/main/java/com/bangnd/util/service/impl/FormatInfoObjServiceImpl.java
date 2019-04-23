package com.bangnd.util.service.impl;

import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.entity.FormatInfo;
import com.bangnd.util.entity.FormatInfoObject;
import com.bangnd.util.repository.FormatInfoObjRepository;
import com.bangnd.util.service.FormatInfoClientMappingService;
import com.bangnd.util.service.FormatInfoObjService;
import com.bangnd.util.service.FormatInfoService;
import com.bangnd.util.string.StringUtil;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FormatInfoObjServiceImpl implements FormatInfoObjService {
    @Autowired
    private FormatInfoObjRepository formatInfoObjRepository;
    @Autowired
    private FormatInfoService formatInfoService;
    @Autowired
    private FormatInfoClientMappingService fc;

    @Override
    public void save(long orderId,FormatInfoObject formatInfoObject,long opeator) {
        FormatInfoObject formatInfoObject1 = formatInfoObjRepository.findByOrderId(orderId);
        if(formatInfoObject1==null){
            formatInfoObject.setOrderId(orderId);
            formatInfoObject.setState(ConstantCfg.STATE_1);
            formatInfoObject.setCreator(Long.valueOf(opeator).intValue());
            formatInfoObject.setCreateTime(new Date());
            formatInfoObjRepository.save(formatInfoObject);
        }else {
            copyNewObjToOldObj(formatInfoObject1,formatInfoObject);
            formatInfoObject1.setUpdateTime(new Date());
            formatInfoObject1.setUpdator(Long.valueOf(opeator).intValue());
            formatInfoObjRepository.saveAndFlush(formatInfoObject1);
        }

    }
    private void copyNewObjToOldObj(FormatInfoObject formatInfoObject1,FormatInfoObject formatInfoObject){
        List<FormatInfo> formatInfoList =  formatInfoService.getAllByBusiType(ConstantCfg.BUSI_TYPE_2);
        for(FormatInfo formatInfo:formatInfoList){
            String enName = formatInfo.getEnName();
            try {
                Method getMethod = formatInfoObject.getClass().getMethod("get"+Character.toUpperCase(enName.charAt(0))+enName.substring(1));
                Method setMethod=null;
                if(formatInfo.getDataType()==1){
                    setMethod = formatInfoObject.getClass().getMethod("set"+Character.toUpperCase(enName.charAt(0))+enName.substring(1),Integer.class);
                }else if(formatInfo.getDataType()==2){
                    setMethod = formatInfoObject.getClass().getMethod("set"+Character.toUpperCase(enName.charAt(0))+enName.substring(1),Long.class);
                }else if(formatInfo.getDataType()==3){
                     setMethod = formatInfoObject.getClass().getMethod("set"+Character.toUpperCase(enName.charAt(0))+enName.substring(1),String.class);
                }else if(formatInfo.getDataType()==4){
                     setMethod = formatInfoObject.getClass().getMethod("set"+Character.toUpperCase(enName.charAt(0))+enName.substring(1),Date.class);
                }else if(formatInfo.getDataType()==5){
                     setMethod = formatInfoObject.getClass().getMethod("set"+Character.toUpperCase(enName.charAt(0))+enName.substring(1),BigDecimal.class);
                }

                if(getMethod.invoke(formatInfoObject)!=null){
                    if(setMethod!=null){
                        setMethod.invoke(formatInfoObject1,getMethod.invoke(formatInfoObject));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public FormatInfoObject getFormatInfoObjByOrderId(long orderId) {
        return formatInfoObjRepository.findByOrderId(orderId);
    }

    @Override
    public void delete(long orderId) {
        formatInfoObjRepository.updateStateByOrderId(orderId);
    }

    /**
     * 注意：
     * 把json字符串解析后的数据插入数据库
     * @param jsonStr
     * @param orderId
     */
    @Override
    public void saveFormatInfo(String jsonStr,long orderId,int type) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        JSONArray jsonArray = StringUtil.toJsonObjByJsonStr(jsonStr);
        FormatInfoObject formatInfoObject = formatInfoObjRepository.findByOrderId(orderId);
        if(formatInfoObject==null){
            formatInfoObject = new FormatInfoObject();
            formatInfoObject.setState(ConstantCfg.STATE_1);
        }
        if(jsonArray!=null&&jsonArray.length()>0){
            for(int i=0;i<jsonArray.length();i++){
                try {
                    JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                    String chName = fc.getFormatInfoKeyByClientKeyAndType((String)jsonObject.get("key"),type);
                    FormatInfo formatInfo = formatInfoService.getFormatInfoByChName(chName);
                    String formatValue = (String)jsonObject.get("value");
                    if(formatInfo!=null){
                        String enName = formatInfo.getEnName();
                        if(formatInfo.getDataType()==4){
                            Date formatDateValue= sdf.parse(formatValue);
                            Method method = formatInfoObject.getClass().getMethod("set"+Character.toUpperCase(enName.charAt(0))+enName.substring(1),Date.class);
                            method.invoke(formatInfoObject,formatDateValue);
                        }else if(formatInfo.getDataType()==5){
                            BigDecimal formatBigDecimalValue = new BigDecimal(formatValue);
                            Method method = formatInfoObject.getClass().getMethod("set"+Character.toUpperCase(enName.charAt(0))+enName.substring(1),BigDecimal.class);
                            method.invoke(formatInfoObject,formatBigDecimalValue);
                        }else {
                            Method method = formatInfoObject.getClass().getMethod("set"+Character.toUpperCase(enName.charAt(0))+enName.substring(1),String.class);
                            method.invoke(formatInfoObject,formatValue);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        formatInfoObject.setOrderId(orderId);
        formatInfoObject.setCreateTime(new Date());
        formatInfoObject.setCreator(0);
        formatInfoObjRepository.save(formatInfoObject);
    }
}
