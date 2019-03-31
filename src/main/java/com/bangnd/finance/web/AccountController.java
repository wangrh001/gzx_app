package com.bangnd.finance.web;

import com.bangnd.finance.entity.Account;
import com.bangnd.finance.form.AccountSearchForm;
import com.bangnd.finance.service.AccountAccountStateService;
import com.bangnd.finance.service.AccountBankService;
import com.bangnd.finance.service.AccountCompanyService;
import com.bangnd.finance.service.AccountService;
import com.bangnd.finance.vo.AccountVO;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @RequestMapping("/finance/account")
    public String home(Model model, @RequestParam(value = "pageNum", required = false) String pageNum, AccountSearchForm accountSearchForm) {
        if (pageNum == null) {
            pageNum = "1";
        }
        Page<Account> pages = accountService.getAccountList(Integer.valueOf(pageNum), ConstantCfg.NUM_PER_PAGE, accountSearchForm);
        model.addAttribute("banks", accountBankService.getAll());
        model.addAttribute("accountStates", accountAccountStateService.getAll());
        model.addAttribute("companys", accountCompanyService.getAll());
        List<AccountVO> accountVOs = new ArrayList<>();
        if (pages != null) {
            for (Account account : pages) {
                AccountVO accountVO = new AccountVO();
                accountVO.setId(account.getId());
                accountVO.setAccountNames(account.getAccountNames());
                accountVO.setAmountNo(account.getAccountNo());
                accountVO.setBankName((accountBankService.getAccountBankById(account.getBank())).getName());
                accountVOs.add(accountVO);
            }
        }
        int pagenum = Integer.valueOf(pageNum);
        model.addAttribute("page", pages);
        model.addAttribute("pageNum", pagenum);
        model.addAttribute("totalPages", pages.getTotalPages());
        System.out.println("totalPages=" + pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
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
        return "/finance/accountEdit";
    }

    @RequestMapping("/finance/account/modify")
    public String modify(Account account, Long id) {
        Account oldAccount = accountService.getAccountById(account.getId());
        oldAccount.setAccountNames(account.getAccountNames());
        oldAccount.setAccountNo(account.getAccountNo());
        oldAccount.setBank(account.getBank());
        oldAccount.setAccountState(account.getAccountState());
        oldAccount.setCompany(account.getCompany());
        oldAccount.setUpdator(0);
        oldAccount.setUpdateTime(new Date());
        accountService.merge(oldAccount);
        return "redirect:/finance/account/toModify?id=" + account.getId();
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