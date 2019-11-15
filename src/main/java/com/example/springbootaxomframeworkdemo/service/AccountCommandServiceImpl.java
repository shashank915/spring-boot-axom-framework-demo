package com.example.springbootaxomframeworkdemo.service;

import com.example.springbootaxomframeworkdemo.domain.commands.CreateAccountCommand;
import com.example.springbootaxomframeworkdemo.domain.commands.CreditMoneyCommand;
import com.example.springbootaxomframeworkdemo.domain.commands.DebitMoneyCommand;
import com.example.springbootaxomframeworkdemo.domain.dto.AccountCreateDTO;
import com.example.springbootaxomframeworkdemo.domain.dto.MoneyCreditDTO;
import com.example.springbootaxomframeworkdemo.domain.dto.MoneyDebitDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

    @Autowired
    private final CommandGateway commandGateway;

    public AccountCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
        return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(),accountCreateDTO.getStartingBalance(),accountCreateDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(MoneyCreditDTO moneyCreditDTO) {
        return commandGateway.send(new CreditMoneyCommand(moneyCreditDTO.getAccountNo(),moneyCreditDTO.getCreditedAmount(),moneyCreditDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(MoneyDebitDTO moneyDebitDTO) {
        return commandGateway.send(new DebitMoneyCommand(moneyDebitDTO.getAccountNo(),moneyDebitDTO.getAmountToBeDebited(), moneyDebitDTO.getCurrency()));
    }
}
