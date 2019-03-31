package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.OrderDocument;
import com.bangnd.cbs.service.DocHandlerService;
import com.bangnd.cbs.service.OrderDocService;
import com.bangnd.cbs.service.OrderLogService;
import com.bangnd.ums.entity.User;
import com.bangnd.util.cfg.ConstantCfg;
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

    @GetMapping("/doc/toUpload")
    public String toUpload(Model model) throws IOException {
        return "/ums/docUpload";
    }

    /**
     * POST请求
     *
     * @param model
     * @param files
     * @return
     */
    @RequestMapping("/doc/upload")
    public String upload(HttpServletRequest request, Model model, @RequestParam("files") MultipartFile[] files, Long orderId) {
        String url = "redirect:/order/toEdit?orderId=" + orderId.toString();
        int userId=Long.valueOf(((User)request.getSession().getAttribute("user")).getId()).intValue();
        Map<String, String> fileNameMapping = new HashMap<String, String>();
        if (files != null && files.length >= 1) {
            try {
                fileNameMapping = docHandlerService.storageFiles(files, orderId.toString());
            } catch (Exception e) {
                model.addAttribute("message", e.getMessage());
                return url;
            }
            for (String uuidName : fileNameMapping.keySet()) {
                OrderDocument orderDocument = new OrderDocument();
                orderDocument.setOrderId(orderId);
                orderDocument.setOriginaName(fileNameMapping.get(uuidName));
                orderDocument.setOriginalFilePath(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId + "/" + fileNameMapping.get(uuidName));
                orderDocument.setUUIDName(uuidName);
                orderDocument.setUUIDNamedFilePath(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId + "/" + uuidName);
                orderDocument.setCondenseNamePath(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId + "/" + uuidName);
                orderDocument.setState(ConstantCfg.PUBLIC_VALID_STATE);
                orderDocument.setCreator(0);
                orderDocument.setCreateTime(new Date());
                orderDocService.save(orderDocument);
            }
            orderLogService.recordLog(orderId,userId,ConstantCfg.ORDER_BUTTON_UPLOADDOC);
            model.addAttribute("message", "文件： " + files.length + "个上传成功!");
            model.addAttribute("files", files);
        }
        return url;
    }

    @RequestMapping("/doc/showAllPic")
    public String showAllPics(Model model, Long orderId) throws IOException {
        List<OrderDocument> orderDocuments = orderDocService.findAllByOrderId(orderId);
        List<String> fileNames = new ArrayList<String>();
        if (orderDocuments != null) {
            for (OrderDocument orderDocument : orderDocuments) {
                fileNames.add("/files/" + orderId + "/" + orderDocument.getUUIDName());
            }
        }
        model.addAttribute("files", fileNames);
        model.addAttribute("orderId", orderId);
        return "/cbs/docUpload";
    }

    //查看已经上传的文件
    @GetMapping("/files/{orderId:.+}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<org.springframework.core.io.Resource> serveFile(@PathVariable String filename, @PathVariable String orderId) {
        org.springframework.core.io.Resource file = docHandlerService.loadAsResource(filename, new Long(orderId).longValue());
        return ResponseEntity.ok(file);
    }
}
