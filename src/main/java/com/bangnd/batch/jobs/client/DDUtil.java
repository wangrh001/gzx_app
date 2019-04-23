package com.bangnd.batch.jobs.client;

import com.bangnd.util.cfg.ConstantCfg;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;

public class DDUtil {
    public static String getAccessToken() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient(ConstantCfg.DD_ACCESS_TOKEN_URL);
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(ConstantCfg.DD_H5_CONSULT_APP_KEY);
        request.setAppsecret(ConstantCfg.DD_H5_CONSULT_APP_SECRET);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        return response.getAccessToken();
    }
}
