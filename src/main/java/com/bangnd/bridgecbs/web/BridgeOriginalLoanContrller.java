package com.bangnd.bridgecbs.web;

import com.bangnd.bridgecbs.entity.BridgeOrder;
import com.bangnd.bridgecbs.entity.OriginalLoanInfo;
import com.bangnd.bridgecbs.service.*;
import com.bangnd.util.service.FormatInfoService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BridgeOriginalLoanContrller {
    @Resource
    private OriginalLoanInfoService originalLoanInfoService;
    @Resource
    private OriginalLoanForeclosureTypeService originalLoanForeclosureTypeService;
    @Resource
    private OriginalLoanTypeService originalLoanTypeService;
    @Resource
    private OriginalLoanOrganTypeService originalLoanOrganTypeService;
    @Resource
    private BridgeOrderAcceptionBankCodeService bridgeOrderAcceptionBankCodeService;

    @Resource
    private BridgeOrderService bridgeOrderService;
    @Resource
    private FormatInfoService formatInfoService;
    /**
     * form表单提交 Date类型数据绑定
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/bridgecbs/originalLoan/add")
    public String addOriginalLoan(OriginalLoanInfo originalLoanInfo,Long orderId){
        originalLoanInfoService.save(originalLoanInfo,orderId);
        BridgeOrder bridgeOrder = bridgeOrderService.getBridgeOrderById(orderId);
        bridgeOrder.setOriginalLoadAmount(originalLoanInfoService.getTotalLoanAmount(orderId));
        bridgeOrder.setOriginalCaptialInterest(originalLoanInfoService.getTotalCaptialInterest(orderId));
        bridgeOrderService.save(bridgeOrder);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + orderId;

    }

    @RequestMapping("/bridgecbs/originalLoan/toModify")
    public String toModify(Model model,Long id){
        try{
            OriginalLoanInfo originalLoanInfo = originalLoanInfoService.getOneById(id);
            model.addAttribute("originalLoanInfo",originalLoanInfo);
            model.addAttribute("foreclosureTypes",originalLoanForeclosureTypeService.getAll());
            //原贷款类型
            model.addAttribute("types", originalLoanTypeService.getAll());
            //原贷款方类型
            model.addAttribute("organTypes", originalLoanOrganTypeService.getAll());
            //原贷款方机构
            model.addAttribute("organCodes", bridgeOrderAcceptionBankCodeService.getAll());
            model.addAttribute("bankCodes", bridgeOrderAcceptionBankCodeService.getAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/bridgecbs/originalLoanEdit";
    }

    @RequestMapping("/bridgecbs/originalLoan/modify")
    public String modify(OriginalLoanInfo originalLoanInfo){
        OriginalLoanInfo originalLoanInfo1 = originalLoanInfoService.getOneById(originalLoanInfo.getId());
        originalLoanInfo1.setOrganType(originalLoanInfo.getOrganType());
        originalLoanInfo1.setOrganCode(originalLoanInfo.getOrganCode());
        originalLoanInfo1.setType(originalLoanInfo.getType());
        originalLoanInfo1.setAmount(originalLoanInfo.getAmount());
        originalLoanInfo1.setCapitalInterest(originalLoanInfo.getCapitalInterest());
        originalLoanInfo1.setEndDate(originalLoanInfo.getEndDate());
        originalLoanInfo1.setAccountNO(originalLoanInfo.getAccountNO());
        originalLoanInfo1.setHasPreStorage(originalLoanInfo.getHasPreStorage());
        originalLoanInfo1.setProstorageDays(originalLoanInfo.getProstorageDays());
        originalLoanInfo1.setBankCode(originalLoanInfo.getBankCode());
        originalLoanInfo1.setAccountName(originalLoanInfo.getAccountName());
        originalLoanInfo1.setContactName(originalLoanInfo.getContactName());
        originalLoanInfo1.setContactPhone(originalLoanInfo.getContactPhone());
        originalLoanInfo1.setForeclosureType(originalLoanInfo.getForeclosureType());
        originalLoanInfo1.setUpdateTime(new Date());
        originalLoanInfoService.merge(originalLoanInfo1);
        BridgeOrder bridgeOrder = bridgeOrderService.getBridgeOrderById(originalLoanInfo1.getOrderId());
        bridgeOrder.setOriginalLoadAmount(originalLoanInfoService.getTotalLoanAmount(originalLoanInfo1.getOrderId()));
        bridgeOrder.setOriginalCaptialInterest(originalLoanInfoService.getTotalCaptialInterest(originalLoanInfo1.getOrderId()));
        bridgeOrderService.save(bridgeOrder);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + originalLoanInfo1.getOrderId();
    }

    @RequestMapping("/bridgecbs/originalLoan/delete")
    public String modify(Long id){
        OriginalLoanInfo originalLoanInfo = originalLoanInfoService.getOneById(id);
        originalLoanInfo.setState(100);
        originalLoanInfoService.merge(originalLoanInfo);
        BridgeOrder bridgeOrder = bridgeOrderService.getBridgeOrderById(originalLoanInfo.getOrderId());
        bridgeOrder.setOriginalLoadAmount(originalLoanInfoService.getTotalLoanAmount(originalLoanInfo.getOrderId()));
        bridgeOrder.setOriginalCaptialInterest(originalLoanInfoService.getTotalCaptialInterest(originalLoanInfo.getOrderId()));
        bridgeOrderService.save(bridgeOrder);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + originalLoanInfo.getOrderId();
    }
}
