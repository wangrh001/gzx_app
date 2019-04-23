package com.bangnd.batch.jobs.client;

import com.bangnd.util.cfg.ConstantCfg;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.taobao.api.ApiException;

public class SendWorkMessageJob {

    public static void sendMessage(String userList,String message) throws ApiException {
        String accessToken=DDUtil.getAccessToken();

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

//        msg.setMsgtype("image");
//        msg.setImage(new OapiMessageCorpconversationAsyncsendV2Request.Image());
//        msg.getImage().setMediaId("@lADOdvRYes0CbM0CbA");
//        request.setMsg(msg);
//
//        msg.setMsgtype("file");
//        msg.setFile(new OapiMessageCorpconversationAsyncsendV2Request.File());
//        msg.getFile().setMediaId("@lADOdvRYes0CbM0CbA");
//        request.setMsg(msg);
//
//        msg.setMsgtype("link");
//        msg.setLink(new OapiMessageCorpconversationAsyncsendV2Request.Link());
//        msg.getLink().setTitle("test");
//        msg.getLink().setText("test");
//        msg.getLink().setMessageUrl("test");
//        msg.getLink().setPicUrl("test");
//        request.setMsg(msg);
//
//        msg.setMsgtype("markdown");
//        msg.setMarkdown(new OapiMessageCorpconversationAsyncsendV2Request.Markdown());
//        msg.getMarkdown().setText("##### text");
//        msg.getMarkdown().setTitle("### Title");
//        request.setMsg(msg);
//
//        msg.setOa(new OapiMessageCorpconversationAsyncsendV2Request.OA());
//        msg.getOa().setHead(new OapiMessageCorpconversationAsyncsendV2Request.Head());
//        msg.getOa().getHead().setText("head");
//        msg.getOa().setBody(new OapiMessageCorpconversationAsyncsendV2Request.Body());
//        msg.getOa().getBody().setContent("xxx");
//        msg.setMsgtype("oa");
//        request.setMsg(msg);
//
//        msg.setActionCard(new OapiMessageCorpconversationAsyncsendV2Request.ActionCard());
//        msg.getActionCard().setTitle("xxx123411111");
//        msg.getActionCard().setMarkdown("### 测试123111");
//        msg.getActionCard().setSingleTitle("测试测试");
//        msg.getActionCard().setSingleUrl("https://www.baidu.com");
//        msg.setMsgtype("action_card");
//        request.setMsg(msg);

        OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request,accessToken);
        System.out.println("发送成功!");
    }

    public static void main(String[] args){
        try {
            sendMessage("manager8154","请检查系统again");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
