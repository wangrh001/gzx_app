package com.bangnd.gw;

import com.bangnd.util.cfg.ConstantCfg;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DingDingGWService {
    /**
     * 获取accessToken
     * @return
     * @throws ApiException
     */
    public static String getAccessToken() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient(ConstantCfg.DD_ACCESS_TOKEN_URL);
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(ConstantCfg.DD_H5_CONSULT_APP_KEY);
        request.setAppsecret(ConstantCfg.DD_H5_CONSULT_APP_SECRET);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        return response.getAccessToken();
    }

    /**
     * 获取某一段时间的审批
     * @param startTime
     * @param endTime
     * @param accessToken
     * @param userList
     * @return
     * @throws ApiException
     */
    public List<String> getAllApproved(Long startTime,Long endTime,String accessToken,String userList ) throws ApiException {
        DingTalkClient client2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/listids");
        OapiProcessinstanceListidsRequest request = new OapiProcessinstanceListidsRequest();
        request.setProcessCode("PROC-RIYJE96V-KGB4KYWS5JUS57RFKAYR3-VV7JW0UJ-K");
        request.setStartTime(startTime);
        request.setEndTime(endTime);
        request.setSize(10L);
        request.setCursor(0L);
        if(userList!=null && !"".equals(userList)){
            request.setUseridList(userList);
        }
        OapiProcessinstanceListidsResponse response2 = client2.execute(request, accessToken);
        if(response2==null||response2.getResult()==null){
            return null;
        }
        //根据每一个审批，获取审批详情
        List<String> approveList =  response2.getResult().getList();
        return approveList;
    }

    /**
     * 获取某一个审批的详细嘻嘻
     * @param approveId
     * @param accessToken
     * @return
     * @throws ApiException
     */
    public OapiProcessinstanceGetResponse getApproveDetail(String approveId,String accessToken) throws ApiException {
        DingTalkClient client3 = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/get");
        OapiProcessinstanceGetRequest request3 = new OapiProcessinstanceGetRequest();
        request3.setProcessInstanceId(approveId);
        return client3.execute(request3,accessToken);
    }

    /**
     * 通过钉钉发送消息
     * @param userList
     * @param message
     * @throws ApiException
     */
    public void sendMessage(String userList,String message) throws ApiException {
        String accessToken=getAccessToken();
        DingTalkClient client = new DefaultDingTalkClient(ConstantCfg.DD_SEND_MESSAGE_URL);

        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        request.setUseridList(userList);
        request.setAgentId(ConstantCfg.DD_AGENT_ID);
        request.setToAllUser(false);

        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype("text");
        msg.setText(new OapiMessageCorpconversationAsyncsendV2Request.Text());
        msg.getText().setContent(message);
        request.setMsg(msg);

        OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request,accessToken);
        System.out.println("发送成功!发送内容："+message);
    }

    /**
     * 获取所有部门
     * @param accessToken
     * @throws ApiException
     */
    public OapiDepartmentListResponse getAllDept(String accessToken) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
        OapiDepartmentListRequest request = new OapiDepartmentListRequest();
        request.setId("1");
        request.setHttpMethod("GET");
        OapiDepartmentListResponse response = client.execute(request, accessToken);
        return response;
    }

    /**
     * 获取部门下的详情，主要是获取负责人
     * @param accessToken
     * @return
     * @throws ApiException
     */
    public OapiDepartmentGetResponse getDeptDetail(String accessToken,Long deptId) throws ApiException{
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/get");
        OapiDepartmentGetRequest request = new OapiDepartmentGetRequest();
        request.setId(String.valueOf(deptId));
        request.setHttpMethod("GET");
        OapiDepartmentGetResponse response = client.execute(request, accessToken);
        return response;
    }

    /**
     * 获取钉钉部门下的所有用户
     */
    public OapiUserListbypageResponse getAllEmployee(long deptId,String accessToken) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/listbypage");
        OapiUserListbypageRequest request = new OapiUserListbypageRequest();
        request.setDepartmentId(deptId);
        request.setOffset(0L);
        request.setSize(10L);
        request.setOrder("entry_desc");
        request.setHttpMethod("GET");

        OapiUserListbypageResponse response = client.execute(request,accessToken);
        return response;
    }



    public static void main(String[] args) throws ApiException {
//        DingDingGWService dingDingGWService = new DingDingGWService();
//        String accessToken=DingDingGWService.getAccessToken();
//        OapiUserListbypageResponse userList = dingDingGWService.getAllEmployee(113208476,accessToken);
//        if(userList!=null && userList.isSuccess() && userList.getUserlist()!=null && userList.getUserlist().size()>0){
//            for(OapiUserListbypageResponse.Userlist dduser:userList.getUserlist()){
//                System.out.println(dduser.getUserid());
//            }
//        }
        String a = "abcdef|gehdeth";
        System.out.println(a.substring(0,a.indexOf("|")));

    }

}
