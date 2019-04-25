package com.bangnd.batch.jobs.client;

import com.bangnd.cbs.service.OrderService;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceGetRequest;
import com.dingtalk.api.request.OapiProcessinstanceListidsRequest;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
import com.dingtalk.api.response.OapiProcessinstanceListidsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LoanApproveReaderJob {
    @Autowired
    private OrderService orderService;

    public List<String> process() throws Exception {
        List<String> provedIdList = new ArrayList<>();
        //获取accessToken
        String accessToken=DDUtil.getAccessToken();

        //获取这个时间间隔的所有审批
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR,-1);

        DingTalkClient client2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/listids");
        OapiProcessinstanceListidsRequest request2 = new OapiProcessinstanceListidsRequest();
        request2.setProcessCode("PROC-RIYJE96V-KGB4KYWS5JUS57RFKAYR3-VV7JW0UJ-K");
        request2.setStartTime(calendar.getTimeInMillis());
        request2.setEndTime(currentDate.getTime());
        request2.setSize(10L);
        request2.setCursor(0L);
        //req.setUseridList("manager1,manager2");
        OapiProcessinstanceListidsResponse response2 = client2.execute(request2, accessToken);
        if(response2==null||response2.getResult()==null){
            return null;
        }
        //根据每一个审批，获取审批详情
        List<String> approveList =  response2.getResult().getList();
        if(approveList!=null && approveList.size()>0){
            for(String approveId:approveList){
                DingTalkClient client3 = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/get");
                OapiProcessinstanceGetRequest request3 = new OapiProcessinstanceGetRequest();
                request3.setProcessInstanceId(approveId);
                OapiProcessinstanceGetResponse response3 = client3.execute(request3,accessToken);
                provedIdList.add(approveId);
                if(response3!=null){
                    orderService.saveClientApprove(approveId,response3);
//                    List<OapiProcessinstanceGetResponse.FormComponentValueVo> vos = response3.getProcessInstance().getFormComponentValues();
//                    for (OapiProcessinstanceGetResponse.FormComponentValueVo vo:vos){
//                            System.out.println(vo.getName());
//                            System.out.println(vo.getValue());
//                    }

                    //调用alibaba的ai服务，格式化这个图片

                }
            }
        }
        return provedIdList;
    }

    public static void main(String[] args) throws Exception{
        LoanApproveReaderJob loanApproveReaderJob = new LoanApproveReaderJob();
        System.out.println(loanApproveReaderJob.process());
    }

}
