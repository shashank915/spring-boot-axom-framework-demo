package com.example.springbootaxomframeworkdemo.domain.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderConfirmedEvent {
    private String orderId;
}
