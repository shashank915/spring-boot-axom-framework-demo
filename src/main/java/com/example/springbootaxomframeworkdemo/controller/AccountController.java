package com.example.springbootaxomframeworkdemo.controller;

import com.example.springbootaxomframeworkdemo.domain.dto.AccountCreateDTO;
import com.example.springbootaxomframeworkdemo.domain.dto.MoneyCreditDTO;
import com.example.springbootaxomframeworkdemo.domain.dto.MoneyDebitDTO;
import com.example.springbootaxomframeworkdemo.service.AccountCommandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@Api(value = "Account Commands", description = "Account Commands Related Endpoints", tags = "Account Commands")
public class AccountController {

    @Autowired
    private final AccountCommandService accountCommandService;

    public AccountController(AccountCommandService accountCommandService) {
        this.accountCommandService = accountCommandService;
    }

    @PostMapping("account/create")
    public CompletableFuture<String> createAccount(@RequestBody AccountCreateDTO accountCreateDTO){
        return this.accountCommandService.createAccount(accountCreateDTO);
    }

    @PutMapping("account/credit")
    public CompletableFuture<String> creditMoneyToAccount(@RequestBody MoneyCreditDTO moneyCreditDTO){
        return this.accountCommandService.creditMoneyToAccount(moneyCreditDTO);
    }

    @PutMapping("/account/debit")
    public CompletableFuture<String> debitMoneyFromAccount(@RequestBody MoneyDebitDTO moneyDebitDTO){
        return  this.accountCommandService.debitMoneyFromAccount(moneyDebitDTO);
    }
}
