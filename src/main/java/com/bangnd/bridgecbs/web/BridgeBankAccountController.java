package com.bangnd.bridgecbs.web;

import com.bangnd.bridgecbs.entity.BankAccount;
import com.bangnd.bridgecbs.service.BankAccountService;
import com.bangnd.bridgecbs.service.BridgeOrderAcceptionBankCodeService;
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
public class BridgeBankAccountController {
    @Resource
    private BankAccountService bankAccountService;
    @Resource
    private BridgeOrderAcceptionBankCodeService bridgeOrderAcceptionBankCodeService;

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

    @RequestMapping("/bridgecbs/bankAccount/add")
    public String addBankAccount(BankAccount bankAccount, Long orderId, Long newLoanId, int type) {
        bankAccount.setType(type);
        bankAccountService.save(bankAccount, orderId, newLoanId);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + orderId;
    }

    @RequestMapping("/bridgecbs/bankAccount/toModify")
    public String toModify(Model model, Long id) {
        try {
            BankAccount bankAccount = bankAccountService.getBankAccountById(id);
            model.addAttribute("bankAccount", bankAccount);
            model.addAttribute("bankIds", bridgeOrderAcceptionBankCodeService.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/bridgecbs/bankAccountEdit";
    }

    @RequestMapping("/bridgecbs/bankAccount/modify")
    public String modify(BankAccount bankAccount) {
        BankAccount bankAccount1 = bankAccountService.getBankAccountById(bankAccount.getId());
        bankAccount1.setAccountCertiCode(bankAccount.getAccountCertiCode());
        bankAccount1.setAccountCode(bankAccount.getAccountCode());
        bankAccount1.setAccountName(bankAccount.getAccountName());
        bankAccount1.setAmount(bankAccount.getAmount());
        bankAccount1.setBankId(bankAccount.getBankId());
        bankAccount1.setUpdateTime(new Date());
        bankAccountService.merge(bankAccount1);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + bankAccount1.getOrderId();
    }

    @RequestMapping("/bridgecbs/bankAccount/delete")
    public String delete(Long id) {
        BankAccount bankAccount = bankAccountService.getBankAccountById(id);
        bankAccount.setState(100);
        bankAccountService.merge(bankAccount);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + bankAccount.getOrderId();
    }
}
