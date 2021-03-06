package io.effective.controller;

import io.effective.dto.Customer;
import io.effective.model.AmsAccount;
import io.effective.service.AccountService;
import io.effective.service.AccountServiceImpl;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        val sess = request.getSession(false);
        if (sess == null)
            return "session is null";
        else
            return sess.getId();
    }

    @GetMapping("/account/{id}")
    public AmsAccount account(@PathVariable long id) {
        val acc = accountService.getAmsAccountById(id);
        return acc;
    }

    @GetMapping("/ops/user/{opsUserId}/customers")
    public List<Customer> customers(@PathVariable String opsUserId) {
        val customers = accountService.getCustomers(opsUserId);
        return customers;
    }

    @PutMapping("/account")
    public Customer create(@RequestBody Customer account) {
        return account;
    }
}
