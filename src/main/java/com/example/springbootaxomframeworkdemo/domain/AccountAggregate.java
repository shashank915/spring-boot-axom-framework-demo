package com.example.springbootaxomframeworkdemo.domain;

import com.example.springbootaxomframeworkdemo.domain.commands.CreateAccountCommand;
import com.example.springbootaxomframeworkdemo.domain.commands.CreditMoneyCommand;
import com.example.springbootaxomframeworkdemo.domain.commands.DebitMoneyCommand;
import com.example.springbootaxomframeworkdemo.domain.event.AccountActivatedEvent;
import com.example.springbootaxomframeworkdemo.domain.event.AccountCreatedEvent;
import com.example.springbootaxomframeworkdemo.domain.event.MoneyCreditedEvent;
import com.example.springbootaxomframeworkdemo.domain.event.MoneyDebitedEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Aggregate
@Data
@NoArgsConstructor
public class AccountAggregate {

    @AggregateIdentifier
//    @Id
    private String accountId;
    private double accountBalance;
    private String currency;
    private Status accountStatus;

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand){
        AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.getId(),createAccountCommand.getAccountBalance(),createAccountCommand.getCurrency()));
    }

    @EventSourcingHandler
    protected void on(AccountCreatedEvent accountCreatedEvent){
        this.accountId = accountCreatedEvent.getId();
        this.accountBalance  = accountCreatedEvent.getAccountBalance();
        this.accountStatus = Status.CREATED;
        this.currency = accountCreatedEvent.getCurrency();

        AggregateLifecycle.apply(new AccountActivatedEvent(this.accountId,Status.ACTIVATED));
    }

    @EventSourcingHandler
    protected void on(AccountActivatedEvent accountActivatedEvent){
        this.accountStatus = Status.ACTIVATED;
    }

    @CommandHandler
    public void handle(CreditMoneyCommand creditMoneyCommand){
        AggregateLifecycle.apply(new MoneyCreditedEvent(creditMoneyCommand.getId(),creditMoneyCommand.getCreditAmount(),creditMoneyCommand.getCurrency()));
    }

    @EventSourcingHandler
    protected void on(MoneyCreditedEvent moneyCreditedEvent){

        if(this.currency.equals(moneyCreditedEvent.getCurrency())) {
            if (this.accountBalance < 0 && (this.accountBalance + moneyCreditedEvent.getCreditAmount()) >= 0) {
                AggregateLifecycle.apply(new AccountActivatedEvent(this.accountId, Status.ACTIVATED));
            }
            this.accountBalance += moneyCreditedEvent.getCreditAmount();
        }else {
            throw new RuntimeException("Money could not be credit! Currency did not match!");
        }
    }

    @CommandHandler
    public void handle(DebitMoneyCommand debitMoneyCommand){
        AggregateLifecycle.apply(new MoneyDebitedEvent(debitMoneyCommand.getId(), debitMoneyCommand.getDebitAmount(), debitMoneyCommand.getCurrency()));
    }

    @EventSourcingHandler
    protected void on(MoneyDebitedEvent moneyDebitedEvent){
        if((this.currency.equals(moneyDebitedEvent.getCurrency())) && (this.accountBalance - moneyDebitedEvent.getMoneyDebited()) >= 0){
            this.accountBalance -= moneyDebitedEvent.getMoneyDebited();
        }else {
            throw new RuntimeException("Not Sufficient Balance to complete this transaction");
        }
    }


}
