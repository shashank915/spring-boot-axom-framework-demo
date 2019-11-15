package com.example.springbootaxomframeworkdemo.domain.commands;

import lombok.Data;

@Data
public class DebitMoneyCommand extends BaseCommand<String> {

    private double debitAmount;
    private String currency;

    public DebitMoneyCommand(String id, double debitAmount, String currency){
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }
}
