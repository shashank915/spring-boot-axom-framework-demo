package com.example.springbootaxomframeworkdemo.domain.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class BaseCommand<T> {

    @TargetAggregateIdentifier
    private T id;
}
