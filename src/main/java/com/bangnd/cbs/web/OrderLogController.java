package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.OrderLog;
import com.bangnd.cbs.form.OrderLogListForm;
import com.bangnd.cbs.service.OrderLogService;
import com.bangnd.hr.service.ActionService;
import com.bangnd.ums.service.ResourceService;
import com.bangnd.ums.service.UserService;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.service.FormatInfoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderLogController {
    @Resource
    OrderLogService orderLogService;
    @Resource
    UserService userService;
    @Resource
    ActionService actionService;
    @Resource
    ResourceService resourceService;
    @Resource
    FormatInfoService formatInfoService;

    @RequestMapping("/orderLog/list")
    public String list(Model model, @RequestParam(value = "pageNum", required = false) String pageNum, long orderId) {

        Page<OrderLog> pages = orderLogService.getAllLogByOrderId(Integer.valueOf(pageNum == null ? "1" : pageNum), ConstantCfg.NUM_PER_PAGE, orderId);
        List<OrderLogListForm> orderLogListForms = new ArrayList<OrderLogListForm>();
        if (pages != null) {
            for (OrderLog orderLog : pages) {
                OrderLogListForm orderLogListForm = new OrderLogListForm();
                orderLogListForm.setId(orderLog.getId());
                orderLogListForm.setUserName((userService.getUserByUserId(orderLog.getUserId()).getUserName()));
                orderLogListForm.setActionTime(orderLog.getOperatorTime());
                if(orderLog.getButtonId()!=0){
                    orderLogListForm.setButtonName(resourceService.getResourceById(orderLog.getButtonId()).getName());
                }else if(orderLog.getFormatInfoId()!=0){
                    orderLogListForm.setButtonName(formatInfoService.getFormatInfoById(orderLog.getFormatInfoId()).getChName());
                }
                orderLogListForm.setActionDesc(orderLog.getActionDesc());
                orderLogListForms.add(orderLogListForm);
            }
        }
        int pagenum = Integer.valueOf(pageNum == null ? "1" : pageNum);
        model.addAttribute("orderId", orderId);
        model.addAttribute("page", pages);
        model.addAttribute("pageNum", Integer.valueOf(pageNum == null ? "1" : pageNum));
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", "共" + pages.getTotalElements() + "条");
        model.addAttribute("orderLogListForms", orderLogListForms);
        return "/cbs/orderLogList";
    }

    @RequestMapping("/orderLog/add")
    public String add(OrderLog orderLog, int buttonId, long orderId) {
        System.out.println("actionId=" + buttonId);
        orderLog.setButtonId(buttonId);
        orderLog.setOrderId(orderId);
        orderLog.setUserId(1);
        orderLog.setOperatorTime(new Date());
        orderLog.setCreator(0);
        orderLog.setCreateTime(new Date());
        orderLog.setState(1);
        orderLogService.save(orderLog);
        return "redirect:/order/list";
    }
}
