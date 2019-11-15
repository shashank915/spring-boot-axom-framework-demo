package com.example.springbootaxomframeworkdemo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyCreditDTO {
    private String accountNo;
    private double creditedAmount;
    private String currency;
}
