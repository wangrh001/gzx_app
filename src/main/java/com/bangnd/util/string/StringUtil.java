package com.bangnd.util.string;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class StringUtil {

    public static JSONArray toJsonObjByJsonStr(String jsonStr){
        JSONArray jsonArray = new JSONArray();
        if(jsonStr!=null&&!"".equals(jsonStr)){
            jsonStr=jsonStr.replaceAll("\\{","").replaceAll("\\}","").replaceAll("\\\\","").replaceAll("\"","");
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

    public static void main(String[] args){
        String str = "{'config_str':'{'side':'face'}','address':'华盛顿特区宾夕法尼亚大道1600号','nationality':'汉','success':true,'num':'','sex':'','name':'奥巴马','birth':'','request_id':'20190424092101_ada688081d158e90b40f75864c6dc365','face_rect':{'size':{'width':76,'height':73},'center':{'x':364.5,'y':168},'angle':-90},'face_rect_vertices':[{'x':401,'y':206},{'x':328,'y':206},{'x':328,'y':130},{'x':401,'y':130}]}";
        System.out.println(toJsonObjByJsonStr(str).toString());
    }
}
