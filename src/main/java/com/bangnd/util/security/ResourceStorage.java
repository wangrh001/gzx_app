package com.bangnd.util.security;

import com.bangnd.ums.entity.Resource;
import com.mysql.cj.xdevapi.JsonArray;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResourceStorage {
    public static void handleResource(HttpServletRequest request, HttpSession session) throws Exception {
        //先将该用户对应的角色，在该链接下所有的子资源获取到，并放入session中。
        List<Resource> resources = (List<Resource>) session.getAttribute("userRes");
        String url = request.getRequestURI();
        setSession(session, resources, url);
    }

    //将查询出来的按钮资源放入session中
    private static void setSession(HttpSession session, List<Resource> resources, String url) throws Exception {
        if (resources != null) {
            long fatherId = 0;
            for (Resource resource : resources) {
                if (url.equals(resource.getResUrl()) && resource.getType() == 1) {
                    fatherId = resource.getId();
                    break;
                }
            }
            JSONArray jsonArray = new JSONArray();
            //List<String> dataResouceStringList = new ArrayList<String>();
//            List<Integer> dataResouceIntegerList = new ArrayList<Integer>();
//            String dataResource = "";
            for (Resource resource : resources) {
                if (resource.getParentId() == fatherId && resource.getState() != 100 && resource.getType() == 2) {
                    JSONObject jo = new JSONObject();
                    jo.put("buttonName", resource.getName());
                    jo.put("ResUrl", resource.getResUrl());

                    jsonArray.put(jo);
//                } else if (resource.getParentId() == fatherId && resource.getState() != 100 && resource.getType() == 3) {
//                    dataResource = dataResource + resource.getValueSet();
                }
            }
//            dataResource = dataResource.replaceAll("\\)\\(", ",");
//            dataResource = dataResource.replaceAll("\\(|\\)", "");
//            dataResouceStringList = Arrays.asList(dataResource.split(","));
//            for (String dataStateString : dataResouceStringList) {
//                dataResouceIntegerList.add(Integer.valueOf(dataStateString));
//            }
            session.setAttribute("buttonRes", jsonArray.toString());
            //session.setAttribute("dataRes", dataResouceIntegerList);
        }
    }
}
