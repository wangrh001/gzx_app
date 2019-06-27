package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.OrderDocType;
import com.bangnd.cbs.entity.OrderDocument;
import com.bangnd.cbs.service.DocHandlerService;
import com.bangnd.cbs.service.OrderDocService;
import com.bangnd.cbs.service.OrderDocTypeService;
import com.bangnd.cbs.service.OrderLogService;
import com.bangnd.ums.entity.User;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.file.FileHandler;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class DocHandlerController {

    @Resource
    OrderDocService orderDocService;

    @Resource
    DocHandlerService docHandlerService;
    @Resource
    OrderLogService orderLogService;
    @Resource
    OrderDocTypeService orderDocTypeService;

    @GetMapping("/doc/toUpload")
    public String toUpload(Model model) throws IOException {
        return "/ums/docUpload";
    }

//    /**
//     * POST请求
//     *
//     * @param model
//     * @param files
//     * @return
//     */
//    @RequestMapping("/doc/upload")
//    public String upload(HttpServletRequest request, Model model, @RequestParam("files") MultipartFile[] files, Long orderId) {
//        String url = "redirect:/order/toEdit?orderId=" + orderId.toString();
//        int userId = Long.valueOf(((User) request.getSession().getAttribute("user")).getId()).intValue();
//        Map<String, String> fileNameMapping = new HashMap<String, String>();
//        if (files != null && files.length >= 1) {
//            try {
//                fileNameMapping = docHandlerService.storageFiles(files, orderId.toString(),"");
//            } catch (Exception e) {
//                model.addAttribute("message", e.getMessage());
//                return url;
//            }
//            for (String uuidName : fileNameMapping.keySet()) {
//                OrderDocument orderDocument = new OrderDocument();
//                orderDocument.setOrderId(orderId);
//                orderDocument.setOriginaName(fileNameMapping.get(uuidName));
//                orderDocument.setOriginalFilePath(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId + "/" + fileNameMapping.get(uuidName));
//                orderDocument.setUUIDName(uuidName);
//                orderDocument.setUUIDNamedFilePath(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId + "/" + uuidName);
//                orderDocument.setCondenseNamePath(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId + "/" + uuidName);
//                orderDocument.setState(ConstantCfg.PUBLIC_VALID_STATE);
//                orderDocument.setCreator(0);
//                orderDocument.setCreateTime(new Date());
//                orderDocService.save(orderDocument);
//            }
//            orderLogService.recordLog(orderId, userId, ConstantCfg.ORDER_BUTTON_UPLOADDOC);
//            model.addAttribute("message", "文件： " + files.length + "个上传成功!");
//            model.addAttribute("files", files);
//        }
//        return url;
//    }

    @RequestMapping("/doc/showAllPic")
    public String showAllPics(Model model, Long orderId) throws IOException {
        List<OrderDocument> orderDocuments = orderDocService.findAllByOrderId(orderId);
        List<String> fileNames = new ArrayList<String>();
        if (orderDocuments != null) {
            for (OrderDocument orderDocument : orderDocuments) {
                String typeName = (orderDocTypeService.getOrderDocTypeById(orderDocument.getDocType())).getChName();
                fileNames.add("/files/" + orderId+ "/" +orderDocument+ "/" + orderDocument.getUUIDName());
            }
        }
        model.addAttribute("files", fileNames);
        model.addAttribute("orderId", orderId);
        return "/bridgecbs/showDoc";
    }

    @RequestMapping("/doc/showPics")
    public String showPics(Model model, Long orderId) throws Exception {
        List<OrderDocType> orderDocTypes = orderDocTypeService.getAll();
        JSONArray jsonArray = new JSONArray();
        if(orderDocTypes!=null && orderDocTypes.size()>0){
            for(OrderDocType orderDocType:orderDocTypes){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("chName",orderDocType.getChName());
                jsonObject.put("enName",orderDocType.getEnName());
                setFilesPaths(orderId, orderDocType, jsonObject);
                jsonArray.put(jsonObject);
            }
        }
        model.addAttribute("typeFiles", jsonArray.toString());
        model.addAttribute("orderId", orderId);
        return "/bridgecbs/showDoc";
    }

    private void setFilesPaths(Long orderId, OrderDocType orderDocType, JSONObject jsonObject) throws JSONException {
        List<OrderDocument> orderDocuments = orderDocService.findAllByOrderIdAndType(orderId,orderDocType.getId());
        if(orderDocuments!=null && orderDocuments.size()>0){
            List<String> fileNames = new ArrayList<>();
            for(OrderDocument orderDocument:orderDocuments){
                fileNames.add("/files/" + orderId+"/"+orderDocType.getChName()+ "/" + orderDocument.getUUIDName());
            }
            jsonObject.put("filesPath",fileNames);
        }
    }

    //查看已经上传的文件
    @GetMapping("/files/{orderId:.+}/{typeName:.+}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<org.springframework.core.io.Resource> serveFile(@PathVariable String filename, @PathVariable String orderId,@PathVariable String typeName) {
        org.springframework.core.io.Resource file = docHandlerService.loadAsResource(filename, new Long(orderId).longValue(),typeName);
        return ResponseEntity.ok(file);
    }

    @RequestMapping("/doc/showAllTypePic")
    public String showAllTypePics(Model model, Long orderId) throws Exception {
        List<OrderDocType> orderDocTypes = orderDocTypeService.getAll();
        JSONArray jsonArray = new JSONArray();
        if(orderDocTypes!=null && orderDocTypes.size()>0){
            for(OrderDocType orderDocType:orderDocTypes){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("chName",orderDocType.getChName());
                jsonObject.put("enName",orderDocType.getEnName());
                jsonObject.put("fileDesc",orderDocType.getFileDesc());
                jsonObject.put("fileType",orderDocType.getFileType());
                jsonObject.put("typeId",orderDocType.getId());
                jsonObject.put("needUpload",true);
                setFilesPaths(orderId, orderDocType, jsonObject);
                jsonArray.put(jsonObject);
            }
        }
        System.out.println("jsonArray.toString()="+jsonArray.toString());
        model.addAttribute("typeFiles", jsonArray.toString());
        model.addAttribute("orderId", orderId);
        return "/bridgecbs/uploadDoc";
    }

    @RequestMapping("/doc/uploadTypeFile")
    public String uploadTypeFile(HttpServletRequest request, Model model, @RequestParam("files") MultipartFile[] files, Long orderId,int typeId) {
        System.out.println("enter the uploadTypeFile== files.length=="+files.length);
        String url = "redirect:/doc/showAllTypePic?orderId=" + orderId.toString();
        int userId = Long.valueOf(((User) request.getSession().getAttribute("user")).getId()).intValue();
        String typeName = (orderDocTypeService.getOrderDocTypeById(typeId)).getChName();
        Map<String, String> fileNameMapping;
        if (files != null && files.length >= 1) {
            try {
                fileNameMapping = docHandlerService.storageFiles(files, orderId.toString(),typeName);
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("message", e.getMessage());
                return url;
            }
            for (String uuidName : fileNameMapping.keySet()) {
                OrderDocument orderDocument = new OrderDocument();
                orderDocument.setOrderId(orderId);
                String fileNamestr = fileNameMapping.get(uuidName);
                orderDocument.setDocFormat(fileNamestr.substring(fileNamestr.length()-3,fileNamestr.length()));
                orderDocument.setOriginaName(fileNameMapping.get(uuidName));
                orderDocument.setOriginalFilePath(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId +"/"+typeName+ "/" + fileNameMapping.get(uuidName));
                orderDocument.setUUIDName(uuidName);
                orderDocument.setUUIDNamedFilePath(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId +"/"+typeName+ "/" + uuidName);
                orderDocument.setCondenseNamePath(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId +"/"+typeName+ "/" + uuidName);
                orderDocument.setState(ConstantCfg.PUBLIC_VALID_STATE);
                orderDocument.setCreator(0);
                orderDocument.setCreateTime(new Date());
                orderDocument.setDocType(typeId);
                orderDocService.save(orderDocument);
            }
            orderLogService.recordLog(orderId, userId, ConstantCfg.ORDER_BUTTON_UPLOADDOC,0,"");
            model.addAttribute("message", "文件： " + files.length + "个上传成功!");
            model.addAttribute("files", files);
        }
        return url;
    }

    @RequestMapping("/doc/downFiles")
    public void downFiles(Long orderId,HttpServletResponse resp){
        DataInputStream in = null;
        OutputStream out = null;
        try {
            resp.reset();// 清空输出流
            String resultFileName = orderId+ ".zip";
            resultFileName = URLEncoder.encode(resultFileName, "UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.setHeader("Content-disposition", "attachment; filename=" + resultFileName);// 设定输出文件头
            resp.setContentType("application/msexcel");// 定义输出类型
            //输入流：本地文件路径
            in = new DataInputStream(new FileInputStream(new File( ConstantCfg.ORDER_DOC_FIXED_PATH+orderId+"/"+ orderId + ".zip")));
            //输出流
            out = resp.getOutputStream();
            //输出文件
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.reset();
            try {
                OutputStreamWriter writer = new OutputStreamWriter(resp.getOutputStream(), "UTF-8");
                String data = "<script language='javascript'>alert(\"\\u64cd\\u4f5c\\u5f02\\u5e38\\uff01\");</script>";
                writer.write(data);
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @RequestMapping("/doc/zipFiles")
    public String zipFiles(Long orderId){
        //先将各个文件夹下面的图片生成pdf
        File jpgFileDir = new File(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId);
        System.out.println("======="+jpgFileDir.getAbsolutePath());
        File[] tempList = jpgFileDir.listFiles();
        for (int i = 0; i < tempList.length; i++) {
            System.out.println("=======1");
            if(tempList[i].isDirectory()){
                String dirStr = tempList[i].getAbsolutePath();
                System.out.println(dirStr.substring(dirStr.lastIndexOf("/")+1,dirStr.length()));
                OrderDocType orderDocType = orderDocTypeService.getOrderDocTypeByName(dirStr.substring(dirStr.lastIndexOf("/")+1,dirStr.length()));
                if(orderDocType!=null){
                    System.out.println("=======3");
                    String fileDesc = orderDocType.getFileDesc();
                    String pdfFileName = fileDesc.substring(fileDesc.indexOf("A"),fileDesc.indexOf("-")+1)+orderDocType.getChName();
                    System.out.println(dirStr+":"+ConstantCfg.ORDER_DOC_FIXED_PATH + orderId+"/pdf/"+pdfFileName+".pdf");
                    FileHandler.toPdf(dirStr,ConstantCfg.ORDER_DOC_FIXED_PATH + orderId+"/pdf/"+pdfFileName+".pdf");
                }
            }
        }
        //再把pdf压缩成zip文件；
        FileHandler.compress(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId+"/pdf",ConstantCfg.ORDER_DOC_FIXED_PATH + orderId+"/"+orderId+".zip");
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + orderId;
    }

}
