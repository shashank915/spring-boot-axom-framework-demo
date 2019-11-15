package com.example.springbootaxomframeworkdemo.domain.commands;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmOrderCommand {

    @TargetAggregateIdentifier
    private String orderId;
}
