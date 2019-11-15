package com.example.springbootaxomframeworkdemo.controller;

import com.example.springbootaxomframeworkdemo.domain.OrderAggregate;
import com.example.springbootaxomframeworkdemo.domain.commands.PlaceOrderCommand;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private FixtureConfiguration<OrderAggregate> fixture;

    @PostMapping("/order/place")
    public void placeOrder(PlaceOrderCommand placeOrderCommand){

    }
}
