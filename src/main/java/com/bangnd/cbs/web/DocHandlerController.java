package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.OrderDocType;
import com.bangnd.cbs.entity.OrderDocument;
import com.bangnd.cbs.service.DocHandlerService;
import com.bangnd.cbs.service.OrderDocService;
import com.bangnd.cbs.service.OrderDocTypeService;
import com.bangnd.cbs.service.OrderLogService;
import com.bangnd.ums.entity.User;
import com.bangnd.util.cfg.ConstantCfg;
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
import java.io.IOException;
import java.util.*;

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

}
