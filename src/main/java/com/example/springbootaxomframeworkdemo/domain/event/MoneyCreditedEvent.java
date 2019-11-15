package com.example.springbootaxomframeworkdemo.domain.event;

import javafx.scene.input.Mnemonic;
import lombok.Data;

@Data
public class MoneyCreditedEvent extends BaseEvent<String> {
    private double creditAmount;
    private String currency;

    public MoneyCreditedEvent(String id, double creditAmount, String currency){
        super(id);
        this.creditAmount = creditAmount;
        this.currency = currency;
    }

}
