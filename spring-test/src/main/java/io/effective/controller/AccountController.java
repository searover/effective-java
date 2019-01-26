package io.effective.controller;

import io.effective.model.AmsAccount;
import io.effective.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController{
    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public AmsAccount account() {
        return accountService.get(100000800000L);
    }
}
