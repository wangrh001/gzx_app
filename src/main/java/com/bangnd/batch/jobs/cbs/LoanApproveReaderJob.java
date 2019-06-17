package com.bangnd.batch.jobs.cbs;

import com.bangnd.bridgecbs.service.BridgeOrderService;
import com.bangnd.cbs.service.OrderService;
import com.bangnd.gw.DingDingGWService;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
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

    @Autowired
    private BridgeOrderService bridgeOrderService;

    @Autowired
    private DingDingGWService dingDingGWService;

    public List<String> process(){
        System.out.println("enter the LoanApproveReader Job");
        List<String> provedIdList = new ArrayList<>();
        try{
            //获取accessToken
            String accessToken=DingDingGWService.getAccessToken();

            //获取这个时间间隔的所有审批
            Date currentDate = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DAY_OF_YEAR,-1);

            List<String> approveList = dingDingGWService.getAllApproved(calendar.getTimeInMillis(),currentDate.getTime(),accessToken,"");
            if(approveList!=null && approveList.size()>0){
                for(String approveId:approveList){
                    OapiProcessinstanceGetResponse response3 =dingDingGWService.getApproveDetail(approveId,accessToken);
                    provedIdList.add(approveId);
                    if(response3!=null){
                        //orderService.saveClientApprove(approveId,response3);
                        bridgeOrderService.saveClientApprove(approveId,response3);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("批量获取钉钉信息的批处理失败，请尽快检查！");
        }
        return provedIdList;
    }

    public static void main(String[] args) throws Exception{
        LoanApproveReaderJob loanApproveReaderJob = new LoanApproveReaderJob();
        System.out.println(loanApproveReaderJob.process());
    }

}
