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
public class AccountController {
    @Resource
    private AccountService accountService;
    @Resource
    AccountBankService accountBankService;
    @Resource
    AccountAccountStateService accountAccountStateService;
    @Resource
    AccountCompanyService accountCompanyService;

    @RequestMapping("/finance/account")
    public String home(Model model, AccountSearchForm accountSearchForm) {
        List<Account> accounts = accountService.getAccountList(accountSearchForm);
        model.addAttribute("banks", accountBankService.getAll());
        model.addAttribute("accountStates", accountAccountStateService.getAll());
        model.addAttribute("companys", accountCompanyService.getAll());
        List<AccountVO> accountVOs = new ArrayList<>();
        if (accounts != null) {
            for (Account account : accounts) {
                AccountVO accountVO = new AccountVO();
                accountVO.setId(account.getId());
                accountVO.setAccountNames(account.getAccountNames());
                accountVO.setAmountNo(account.getAmountNo());
                accountVO.setBankName((accountBankService.getAccountBankById(account.getBank())).getName());
                accountVOs.add(accountVO);
            }
        }
        model.addAttribute("accountVOs", accountVOs);
        return "/finance/accountList";
    }

    @RequestMapping("/finance/account/toAdd")
    public String toAdd(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        model.addAttribute("banks", accountBankService.getAll());
        model.addAttribute("accountStates", accountAccountStateService.getAll());
        model.addAttribute("companys", accountCompanyService.getAll());
        return "/finance/accountAdd";
    }

    @RequestMapping("/finance/account/add")
    public String add(Account account) {
        account.setState(ConstantCfg.ORDER_STATE_INITIAL);
        account.setCreator(0);
        account.setCreateTime(new Date());
        accountService.save(account);
        return "redirect:/finance/account";
    }

    @RequestMapping("/finance/account/toModify")
    public String toModify(Model model, Long id) {
        Account account = accountService.getAccountById(id);
        model.addAttribute("account", account);
        model.addAttribute("banks", accountBankService.getAll());
        model.addAttribute("accountStates", accountAccountStateService.getAll());
        model.addAttribute("companys", accountCompanyService.getAll());
        return "/finance/accountAdd";
    }

    @RequestMapping("/finance/account/modify")
    public String modify(Account account, Long id) {
        Account oldAccount = accountService.getAccountById(id);
        oldAccount.setAccountNames(account.getAccountNames());
        oldAccount.setAmountNo(account.getAmountNo());
        oldAccount.setBank(account.getBank());
        oldAccount.setAccountState(account.getAccountState());
        oldAccount.setCompany(account.getCompany());
        oldAccount.setUpdator(0);
        oldAccount.setUpdateTime(new Date());
        accountService.merge(oldAccount);
        return "redirect:/finance/account/toModify?id=" + id;
    }

    @RequestMapping("/finance/account/delete")
    public String delete(Long id) {
        Account oldAccount = accountService.getAccountById(id);
        oldAccount.setState(100);
        oldAccount.setUpdator(0);
        oldAccount.setUpdateTime(new Date());
        accountService.merge(oldAccount);
        return "redirect:/finance/account";
    }
}