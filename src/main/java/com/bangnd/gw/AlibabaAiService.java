package com.bangnd.gw;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bangnd.util.http.HttpUtils;
import com.bangnd.util.string.StringUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.codec.binary.Base64.encodeBase64;


public class AlibabaAiService {
    /*
     * 获取参数的json对象
     */
    public JSONObject getParam(int type, String dataValue) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("dataType", type);
            obj.put("dataValue", dataValue);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    private String getBodys(String imgFile,String config_str,Boolean is_old_format,String orcType){
        // 对图像进行base64编码
        String imgBase64 = "";
        try {
            File file = new File(imgFile);
            byte[] content = new byte[(int) file.length()];
            FileInputStream finputstream = new FileInputStream(file);
            finputstream.read(content);
            finputstream.close();
            imgBase64 = new String(encodeBase64(content));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // 拼装请求body的json字符串
        JSONObject requestObj = new JSONObject();
        try {
            if(is_old_format) {
                JSONObject obj = new JSONObject();
                obj.put("image", getParam(50, imgBase64));
                if(config_str.length() > 0) {
                    obj.put("configure", getParam(50, config_str));
                }
                JSONArray inputArray = new JSONArray();
                inputArray.add(obj);
                requestObj.put("inputs", inputArray);
            }else{
                if("certi".equals(orcType)){
                    requestObj.put("image", imgBase64);
                }else if("house".equals(orcType)){
                    requestObj.put("img", imgBase64);
                }

                if(config_str.length() > 0) {
                    requestObj.put("configure", config_str);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return requestObj.toString();
    }

    public String certiCodeOCR(String imgFile){
        String formatStr = certiCodeOCR(imgFile,"face");
        if(formatStr!=null && formatStr.contains("address")){
            return formatStr;
        }
        formatStr = certiCodeOCR(imgFile,"back");
        if(formatStr!=null && formatStr.contains("issue")){
            return formatStr;
        }
        return "";
    }

    /**
     * OCR身份证信息
     * @param imgFile
     * @return
     */
    public String certiCodeOCR(String imgFile,String faceBack){
        String host = "http://dm-51.data.aliyun.com";
        String path = "/rest/160601/ocr/ocr_idcard.json";
        //String imgFile = "/Users/wrh/Documents/wrh/work/gzx_app/uploadfile/raw/byOrder/80/66d1910fb16f9fc5a8a1b650ab2d0f5b.jpg";
        String appcode = "2d1117454a4d4a91999f6ca7c83ae63e";
        Boolean is_old_format = false;//如果文档的输入中含有inputs字段，设置为True， 否则设置为False
        //请根据线上文档修改configure字段
        JSONObject configObj = new JSONObject();
        configObj.put("side", faceBack);
        String config_str = configObj.toString();
        //            configObj.put("min_size", 5);
        //            String config_str = "";

        String method = "POST";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        String bodys = getBodys(imgFile,config_str,is_old_format,"certi");
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            int stat = response.getStatusLine().getStatusCode();
            if(stat != 200){
                System.out.println("Http code: " + stat);
                System.out.println("http header error msg: "+ response.getFirstHeader("X-Ca-Error-Message"));
                System.out.println("Http body error msg:" + EntityUtils.toString(response.getEntity()));
                return "";
            }
            String res = EntityUtils.toString(response.getEntity());
            JSONObject res_obj = JSON.parseObject(res);
            System.out.println("res_obj.toJSONString()="+res_obj.toJSONString());
            if(is_old_format) {
                JSONArray outputArray = res_obj.getJSONArray("outputs");
                String output = outputArray.getJSONObject(0).getJSONObject("outputValue").getString("dataValue");
                JSONObject out = JSON.parseObject(output);
                return out.toJSONString();
            }else{
                return res_obj.toJSONString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * OCR房产证
     * @param imgFile
     * @return
     */
    public String houseOCR(String imgFile){
        String host = "https://ocrapi-house-cert.taobao.com";
        String path = "/ocrservice/houseCert";
        String method = "POST";
        //String filePath = "/Users/wrh/Documents/wrh/work/gzx_app/uploadfile/raw/byOrder/80/717a2a715bc8447d0bef39c0b32c89ef.jpg";
        String appcode = "2d1117454a4d4a91999f6ca7c83ae63e";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        String bodys = getBodys(imgFile,"",false,"house");
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args){
        AlibabaAiService alibabaAiService = new AlibabaAiService();
        String certiimgFileFace = "/Users/wrh/Documents/wrh/work/gzx_app/uploadfile/raw/byOrder/92/身份证明/lADPDgQ9qoteJv3NAULNAfA_496_322.jpg";
        System.out.println(StringUtil.toJsonObjByJsonStr(alibabaAiService.certiCodeOCR(certiimgFileFace,"face")).toString());
        String certiimgFileback = "/Users/wrh/Documents/wrh/work/gzx_app/uploadfile/raw/byOrder/92/身份证明/lADPDgQ9qoteJwLNAq3NBA8_1039_685.jpg";
        System.out.println(StringUtil.toJsonObjByJsonStr(alibabaAiService.certiCodeOCR(certiimgFileback,"back")).toString());
        String imgFile = "/Users/wrh/Documents/wrh/work/gzx_app/uploadfile/raw/byOrder/92/房产证/lADPDgQ9qoteJwzNA0vNBdw_1500_843.jpg";
        System.out.println(StringUtil.toJsonObjByJsonStr(alibabaAiService.houseOCR(imgFile)).toString());
    }
}

