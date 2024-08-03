package com.zjyun.springboot.controller;

import com.zjyun.springboot.entity.Account;
import com.zjyun.springboot.service.IAccountService;
import com.zjyun.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangzijian
 * @since 2024-07-30
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    private final IAccountService accountService;

    @Autowired
    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("{id}")
    public Result<Account> getAccount(@PathVariable Integer id) {
        Account account = accountService.getById(id);
        return Result.success(account);
    }

    @GetMapping("/accounts")
    public Result accounts(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return accountService.queryAccountListPaging(pageNo, pageSize);
    }
    @DeleteMapping("/{id}")
    public Result deleteAccount(@PathVariable Integer id) {
        return accountService.deleteAccount(id);
    }
}
