package com.bangnd.batch.jobs.cbs;

//import com.alibaba.dingtalk.openapi.demo.Env;
//import com.alibaba.dingtalk.openapi.demo.OApiException;
//import com.alibaba.dingtalk.openapi.demo.OApiResultException;
//import com.alibaba.dingtalk.openapi.demo.utils.HttpHelper;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.dingtalk.open.client.ServiceFactory;
//import com.dingtalk.open.client.api.model.corp.Department;
//import com.dingtalk.open.client.api.service.corp.CorpDepartmentService;
//import com.dingtalk.open.client.common.SdkInitException;
//import com.dingtalk.open.client.common.ServiceException;
//import com.dingtalk.open.client.common.ServiceNotExistException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DingDingService {
    /**
     * 获取钉钉的accessToken
     * @param url
     * @return
     * dingp8i1bliju3ipdsox
     * y13aW24oLr-lMBFP3tLDOZz9De12Bkcx794d4dHRtQormBcZhFDbrzZKUP-G9tqj
     */
    public static String getAccessToken(String url){

//        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
//        OapiGettokenRequest request = new OapiGettokenRequest();
//        request.setAppkey("appkey");
//        request.setAppsecret("appsecret");
//        request.setHttpMethod("GET");
//        OapiGettokenResponse response = client.execute(request);
        url="https://oapi.dingtalk.com/gettoken";
        String result = "";
        String line;
        StringBuffer sb=new StringBuffer();
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + "appkey=\"dingp8i1bliju3ipdsox\"&&appsecret=\"y13aW24oLr-lMBFP3tLDOZz9De12Bkcx794d4dHRtQormBcZhFDbrzZKUP-G9tqj\"";
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性 设置请求格式
            conn.setRequestProperty("contentType", "UTF-8");
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            //设置超时时间
            conn.setConnectTimeout(60);
            conn.setReadTimeout(60);
            // 建立实际的连接
            conn.connect();
            // 定义 BufferedReader输入流来读取URL的响应,设置接收格式
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(),"UTF-8"));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result=sb.toString();
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args){
        getAccessToken("");

//        https://oapi.dingtalk.com/topapi/processinstance/listids?access_token=3caa166d0fc135b8903f581041bfcace
    }
}
