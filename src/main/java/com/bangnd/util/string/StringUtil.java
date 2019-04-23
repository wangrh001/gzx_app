package com.bangnd.util.string;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class StringUtil {

    public static JSONArray toJsonObjByJsonStr(String jsonStr){
        JSONArray jsonArray = new JSONArray();
        if(jsonStr!=null&&!"".equals(jsonStr)){
            jsonStr=jsonStr.replaceAll("\\{","").replaceAll("\\}","");
            String[] strArr = jsonStr.split(",");
            if(strArr!=null && strArr.length>0){
                for(int i=0;i<strArr.length;i++){
                    String[] subStrArr = strArr[i].split(":");
                    if(subStrArr!=null && subStrArr.length==2){
                        JSONObject jo = new JSONObject();
                        try {
                            jo.put("key",subStrArr[0]);
                            jo.put("value",subStrArr[1]);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            return null;
                        }
                        jsonArray.put(jo);
                    }
                }
            }
        }
        return jsonArray;
    }
}
