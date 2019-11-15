package com.example.springbootaxomframeworkdemo.domain.event;

import lombok.Data;

@Data
public class MoneyDebitedEvent extends BaseEvent<String> {

    private double moneyDebited;
    private String currency;

    public  MoneyDebitedEvent(String id, double moneyDebited, String currency){
        super(id);
        this.moneyDebited = moneyDebited;
        this.currency = currency;
    }
}
