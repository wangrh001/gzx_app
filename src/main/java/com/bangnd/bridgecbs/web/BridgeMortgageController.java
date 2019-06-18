package com.bangnd.bridgecbs.web;

import com.bangnd.bridgecbs.entity.BridgeCustomer;
import com.bangnd.bridgecbs.entity.BridgeOrder;
import com.bangnd.bridgecbs.entity.Mortgage;
import com.bangnd.bridgecbs.service.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BridgeMortgageController {
    @Resource
    private MortgageService mortgageService;
    @Resource
    private MortgagePropertyTypeService mortgagePropertyTypeService;
    @Resource
    private MortgagePropertyStatesService mortgagePropertyStatesService;
    @Resource
    private MortgageEstateTypeService mortgageEstateTypeService;
    @Resource
    private BridgeOrderService bridgeOrderService;

    @Resource
    private CustomerService customerService;
    @Resource
    private BridgeOrderCertiTypeService bridgeOrderCertiTypeService;

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

    @RequestMapping("/bridgecbs/mortgage/add")
    public String addMortgage(Mortgage mortgage,Long orderId){
        mortgageService.save(mortgage,orderId);
        BridgeOrder bridgeOrder = bridgeOrderService.getBridgeOrderById(orderId);
        bridgeOrder.setTotalRegisterPrice(mortgageService.getTotalRegisterPrice(orderId));
        bridgeOrder.setTotalEstimatePrice(mortgageService.getTotalEstimatePrice(orderId));
        bridgeOrderService.save(bridgeOrder);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + orderId;
    }

    @RequestMapping("/bridgecbs/mortgage/toModify")
    public String toModify(Model model, Long id){
        try {
            Mortgage mortgage = mortgageService.getOneById(id);
            model.addAttribute("mortgage",mortgage);
            model.addAttribute("orderId",id);
            List<BridgeCustomer> bridgeCustomerList =customerService.getAllByOrderMortgageId(id);
            model.addAttribute("bridgeCustomerList",bridgeCustomerList);

            BridgeCustomer bridgeCustomer = new BridgeCustomer();
            model.addAttribute("customer",bridgeCustomer);
            //物业业务类型
            model.addAttribute("propertyTypes", mortgagePropertyTypeService.getAll());
            //产权状态
            model.addAttribute("propertyStates", mortgagePropertyStatesService.getAll());
            //房屋类型
            model.addAttribute("estateTypes", mortgageEstateTypeService.getAll());
            //证件类型
            model.addAttribute("certiTypes", bridgeOrderCertiTypeService.getAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/bridgecbs/bridgeMortgageEdit";
    }

    @RequestMapping("/bridgecbs/mortgage/modify")
    public String modify(Mortgage mortgage){
        Mortgage mortgage1 = mortgageService.getOneById(mortgage.getMortgageId());
        mortgage1.setPropertyType(mortgage.getPropertyType());
        mortgage1.setEstateArea(mortgage.getEstateArea());
        mortgage1.setPropertyNO(mortgage.getPropertyNO());
        mortgage1.setRegisterPrice(mortgage.getRegisterPrice());
        mortgage1.setEstimatePrice(mortgage.getEstimatePrice());
        mortgage1.setCanLoanPercent(mortgage.getCanLoanPercent());
        mortgage1.setCanLoanAmount(mortgage.getCanLoanAmount());
        mortgage1.setEstatePrice(mortgage.getEstatePrice());
        mortgage1.setPropertyUse(mortgage.getPropertyUse());
        mortgage1.setPropertyState(mortgage.getPropertyState());
        mortgage1.setPropertyType(mortgage.getPropertyType());
        mortgage1.setEstateType(mortgage.getEstateType());
        mortgage1.setHouseAddress(mortgage.getHouseAddress());
        mortgage1.setUpdateTime(new Date());
        mortgageService.merge(mortgage1);
        BridgeOrder bridgeOrder = bridgeOrderService.getBridgeOrderById(mortgage1.getOrderId());
        bridgeOrder.setTotalRegisterPrice(mortgageService.getTotalRegisterPrice(mortgage1.getOrderId()));
        bridgeOrder.setTotalEstimatePrice(mortgageService.getTotalEstimatePrice(mortgage1.getOrderId()));
        bridgeOrderService.save(bridgeOrder);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + mortgage1.getOrderId();
    }

    @RequestMapping("/bridgecbs/mortgage/delete")
    public String delete(Long  id){
        Mortgage mortgage = mortgageService.getOneById(id);
        mortgage.setState(100);
        mortgageService.merge(mortgage);
        BridgeOrder bridgeOrder = bridgeOrderService.getBridgeOrderById(mortgage.getOrderId());
        bridgeOrder.setTotalRegisterPrice(mortgageService.getTotalRegisterPrice(mortgage.getOrderId()));
        bridgeOrder.setTotalEstimatePrice(mortgageService.getTotalEstimatePrice(mortgage.getOrderId()));
        bridgeOrderService.save(bridgeOrder);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + mortgage.getOrderId();
    }
}
