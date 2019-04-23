package com.bangnd.client;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiProcessinstanceGetRequest;
import com.dingtalk.api.request.OapiProcessinstanceListidsRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
import com.dingtalk.api.response.OapiProcessinstanceListidsResponse;
import com.taobao.api.ApiException;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;


public class ClientAppController {
    @RequestMapping("/client/order/consult")
    public String consult(Long orderId) {
        return "/client/input";
    }

    private static String getDDtoken() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey("dingiw2xnv2sn0buaedk");
        request.setAppsecret("aZwljuGaTh-gXBQXKBq4P0i33U6vZ30E0pEcB5qrNdaHgEwlKsIeR_w-LH1pwcPT");
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        return response.getAccessToken();
    }

    private static void getApproved(String accessToken) throws ApiException {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR,-1);

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/listids");
        OapiProcessinstanceListidsRequest req = new OapiProcessinstanceListidsRequest();
        req.setProcessCode("PROC-RIYJE96V-KGB4KYWS5JUS57RFKAYR3-VV7JW0UJ-K");
        req.setStartTime(calendar.getTimeInMillis());
        req.setEndTime(currentDate.getTime());
        req.setSize(10L);
        req.setCursor(0L);
        //req.setUseridList("manager1,manager2");
        OapiProcessinstanceListidsResponse response = client.execute(req, accessToken);
        System.out.println(response.getResult().getList());
    }

    private static void getApprovedDetail(String accessToken) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/get");
        OapiProcessinstanceGetRequest request = new OapiProcessinstanceGetRequest();
        request.setProcessInstanceId("064deaf4-b054-4ed1-8107-c73a7b040000");
        OapiProcessinstanceGetResponse response = client.execute(request,accessToken);
        System.out.println(response.getProcessInstance().getOriginatorUserid());
        for (OapiProcessinstanceGetResponse.FormComponentValueVo vo:response.getProcessInstance().getFormComponentValues()){
            System.out.println(vo.getName());
            System.out.println(vo.getValue());
        }
    }
   public static void main(String[] args) throws ApiException{
       getApprovedDetail(getDDtoken());
    }


}