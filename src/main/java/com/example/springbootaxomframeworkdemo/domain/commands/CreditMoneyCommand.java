package com.example.springbootaxomframeworkdemo.domain.commands;

import lombok.Data;
//import org.springframework.data.mongodb.core.query.CriteriaDefinition;

@Data
public class CreditMoneyCommand extends BaseCommand<String> {

    private double creditAmount;
    private String currency;

    public CreditMoneyCommand(String id, double creditAmount, String currency){
        super(id);
        this.creditAmount = creditAmount;
        this.currency = currency;
    }
}
