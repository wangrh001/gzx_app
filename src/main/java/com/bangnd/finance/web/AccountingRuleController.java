package com.bangnd.finance.web;

import com.bangnd.finance.entity.AccountingRule;
import com.bangnd.finance.form.AccountingRuleSearchForm;
import com.bangnd.finance.service.AccountBalanceService;
import com.bangnd.finance.service.AccountingRuleFeeTypeService;
import com.bangnd.finance.service.AccountingRuleService;
import com.bangnd.finance.vo.AccountingRuleVO;
import com.bangnd.util.cfg.ConstantCfg;
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
public class AccountingRuleController {
    @Resource
    private AccountingRuleService accountingRuleService;
    @Resource
    AccountingRuleFeeTypeService accountingRuleFeeTypeService;
    @Resource
    AccountBalanceService accountBalanceService;

    @RequestMapping("/finance/accountingRule")
    public String home(Model model, @RequestParam(value="pageNum",required=false) String pageNum, AccountingRuleSearchForm accountingRuleSearchForm) {
        if(pageNum==null){
            pageNum="1";
        }
        Page<AccountingRule> pages = accountingRuleService.getAccountingRuleList(Integer.valueOf(pageNum),ConstantCfg.NUM_PER_PAGE,accountingRuleSearchForm);
        model.addAttribute("feeTypes", accountingRuleFeeTypeService.getAll());
        model.addAttribute("debitSides", accountBalanceService.getAll());
        model.addAttribute("creditSides", accountBalanceService.getAll());
        List<AccountingRuleVO> accountingRuleVOs = new ArrayList<>();
        if (pages != null) {
            for (AccountingRule accountingRule : pages) {
                AccountingRuleVO accountingRuleVO = new AccountingRuleVO();
                accountingRuleVO.setId(accountingRule.getId());
                accountingRuleVO.setFeeTypeName((accountingRuleFeeTypeService.getAccountingRuleFeeTypeById(accountingRule.getFeeType())).getName());
                accountingRuleVO.setDebitSideName((accountBalanceService.getAccountBalanceById(accountingRule.getDebitSide())).getName());
                accountingRuleVO.setCreditSideName((accountBalanceService.getAccountBalanceById(accountingRule.getCreditSide())).getName());
                accountingRuleVOs.add(accountingRuleVO);
            }
        }

        int pagenum=Integer.valueOf(pageNum);
        model.addAttribute("page",pages);
        model.addAttribute("pageNum",pagenum);
        model.addAttribute("totalPages",pages.getTotalPages());
        System.out.println("totalPages="+pages.getTotalPages());
        model.addAttribute("totalElements",pages.getTotalElements());
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