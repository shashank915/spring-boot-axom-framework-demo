package com.example.springbootaxomframeworkdemo.domain;

import com.example.springbootaxomframeworkdemo.domain.commands.ConfirmOrderCommand;
import com.example.springbootaxomframeworkdemo.domain.commands.PlaceOrderCommand;
import com.example.springbootaxomframeworkdemo.domain.commands.ShipOrderCommand;
import com.example.springbootaxomframeworkdemo.domain.event.OrderConfirmedEvent;
import com.example.springbootaxomframeworkdemo.domain.event.OrderPlacedEvent;
import com.example.springbootaxomframeworkdemo.domain.event.OrderShippedEvent;
import com.example.springbootaxomframeworkdemo.domain.exception.UnconfirmedOrderException;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDateTime;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private LocalDateTime orderDateTime = LocalDateTime.now();
    private boolean orderConfirmed;

    //command handler method which will be executed when order is placed
    @CommandHandler
    public OrderAggregate(PlaceOrderCommand placeOrderCommand){
        AggregateLifecycle.apply(new OrderPlacedEvent(placeOrderCommand.getOrderId(),placeOrderCommand.getProduct()));
    }

    //command handler method which will be executed when order is confirmed
    @CommandHandler
    public void handle(ConfirmOrderCommand confirmOrderCommand){
        AggregateLifecycle.apply(new OrderConfirmedEvent(confirmOrderCommand.getOrderId()));
    }

    //command handler method which will be executed when order is shipped
    @CommandHandler
    public void handle(ShipOrderCommand shipOrderCommand){
        if(!this.orderConfirmed){
            throw new UnconfirmedOrderException();
        }
        AggregateLifecycle.apply(new OrderShippedEvent(shipOrderCommand.getOrderId()));
    }

    @EventSourcingHandler
    public void on(OrderPlacedEvent orderPlacedEvent){
        this.orderId = orderPlacedEvent.getOrderId();
        this.orderConfirmed = false;
    }

    @EventSourcingHandler
    public void on(OrderConfirmedEvent orderConfirmedEvent){
        this.orderConfirmed = true;
    }
}
