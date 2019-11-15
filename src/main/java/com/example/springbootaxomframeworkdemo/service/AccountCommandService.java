package com.example.springbootaxomframeworkdemo.service;

import com.example.springbootaxomframeworkdemo.domain.dto.AccountCreateDTO;
import com.example.springbootaxomframeworkdemo.domain.dto.MoneyCreditDTO;
import com.example.springbootaxomframeworkdemo.domain.dto.MoneyDebitDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {

    CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
    CompletableFuture<String> creditMoneyToAccount(MoneyCreditDTO moneyCreditDTO);
    CompletableFuture<String> debitMoneyFromAccount(MoneyDebitDTO moneyDebitDTO);
}
