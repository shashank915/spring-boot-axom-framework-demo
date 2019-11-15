package com.example.springbootaxomframeworkdemo.domain.commands;

import com.example.springbootaxomframeworkdemo.domain.AccountAggregate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CreateAccountCommand extends BaseCommand<String>{

    private double accountBalance;
    private String currency;

    public CreateAccountCommand(String id, double accountBalance, String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
}
