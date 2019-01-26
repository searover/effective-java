package io.effective.controller;

import io.effective.model.AmsAccount;
import io.effective.service.AccountService;
import io.effective.service.AccountServiceImpl;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/account/{id}")
    public AmsAccount account(@PathVariable long id) {
        val acc = accountService.getAmsAccountById(id);
        return acc;
    }
}
