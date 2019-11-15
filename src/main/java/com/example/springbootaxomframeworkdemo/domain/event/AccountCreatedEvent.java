package com.example.springbootaxomframeworkdemo.domain.event;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AccountCreatedEvent extends BaseEvent<String> {

    private double accountBalance;
    private String currency;

    public AccountCreatedEvent(String id, double accountBalance, String currency){
        super((id));
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
}
