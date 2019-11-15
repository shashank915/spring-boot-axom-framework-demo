package com.example.springbootaxomframeworkdemo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyDebitDTO {

    private String accountNo;
    private double amountToBeDebited;
    private String currency;
}
