package com.bangnd.finance.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import java.util.*;

import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.finance.web.*;
import com.bangnd.finance.entity.*;
import com.bangnd.finance.form.*;
import com.bangnd.finance.service.*;
import com.bangnd.finance.service.impl.*;
import com.bangnd.finance.vo.*;

@Controller
public class AccountingRuleController {
    @Resource
    private AccountingRuleService accountingRuleService;
    @Resource
    AccountingRuleFeeTypeService accountingRuleFeeTypeService;
    @Resource
    AccountBalanceService accountBalanceService;

    @RequestMapping("/finance/accountingRule")
    public String home(Model model, AccountingRuleSearchForm accountingRuleSearchForm) {
        List<AccountingRule> accountingRules = accountingRuleService.getAccountingRuleList(accountingRuleSearchForm);
        model.addAttribute("feeTypes", accountingRuleFeeTypeService.getAll());
        model.addAttribute("debitSides", accountBalanceService.getAll());
        model.addAttribute("creditSides", accountBalanceService.getAll());
        List<AccountingRuleVO> accountingRuleVOs = new ArrayList<>();
        if (accountingRules != null) {
            for (AccountingRule accountingRule : accountingRules) {
                AccountingRuleVO accountingRuleVO = new AccountingRuleVO();
                accountingRuleVO.setId(accountingRule.getId());
                accountingRuleVO.setFeeTypeName((accountingRuleFeeTypeService.getAccountingRuleFeeTypeById(accountingRule.getFeeType())).getName());
                accountingRuleVO.setDebitSideName((accountBalanceService.getAccountBalanceById(accountingRule.getDebitSide())).getName());
                accountingRuleVO.setCreditSideName((accountBalanceService.getAccountBalanceById(accountingRule.getCreditSide())).getName());
                accountingRuleVOs.add(accountingRuleVO);
            }
        }
        model.addAttribute("accountingRuleVOs", accountingRuleVOs);
        return "/finance/accountingRuleList";
    }

    @RequestMapping("/finance/accountingRule/toAdd")
    public String toAdd(Model model) {
        AccountingRule accountingRule = new AccountingRule();
        model.addAttribute("accountingRule", accountingRule);
        model.addAttribute("feeTypes", accountingRuleFeeTypeService.getAll());
        model.addAttribute("debitSides", accountBalanceService.getAll());
        model.addAttribute("creditSides", accountBalanceService.getAll());
        return "/finance/accountingRuleAdd";
    }

    @RequestMapping("/finance/accountingRule/add")
    public String add(AccountingRule accountingRule) {
        accountingRule.setState(ConstantCfg.ORDER_STATE_INITIAL);
        accountingRule.setCreator(0);
        accountingRule.setCreateTime(new Date());
        accountingRuleService.save(accountingRule);
        return "redirect:/finance/accountingRule";
    }

    @RequestMapping("/finance/accountingRule/toModify")
    public String toModify(Model model, Long id) {
        AccountingRule accountingRule = accountingRuleService.getAccountingRuleById(id);
        model.addAttribute("accountingRule", accountingRule);
        model.addAttribute("feeTypes", accountingRuleFeeTypeService.getAll());
        model.addAttribute("debitSides", accountBalanceService.getAll());
        model.addAttribute("creditSides", accountBalanceService.getAll());
        return "/finance/accountingRuleAdd";
    }

    @RequestMapping("/finance/accountingRule/modify")
    public String modify(AccountingRule accountingRule, Long id) {
        AccountingRule oldAccountingRule = accountingRuleService.getAccountingRuleById(id);
        oldAccountingRule.setFeeType(accountingRule.getFeeType());
        oldAccountingRule.setDebitSide(accountingRule.getDebitSide());
        oldAccountingRule.setCreditSide(accountingRule.getCreditSide());
        oldAccountingRule.setUpdator(0);
        oldAccountingRule.setUpdateTime(new Date());
        accountingRuleService.merge(oldAccountingRule);
        return "redirect:/finance/accountingRule/toModify?id=" + id;
    }

    @RequestMapping("/finance/accountingRule/delete")
    public String delete(Long id) {
        AccountingRule oldAccountingRule = accountingRuleService.getAccountingRuleById(id);
        oldAccountingRule.setState(100);
        oldAccountingRule.setUpdator(0);
        oldAccountingRule.setUpdateTime(new Date());
        accountingRuleService.merge(oldAccountingRule);
        return "redirect:/finance/accountingRule";
    }
}