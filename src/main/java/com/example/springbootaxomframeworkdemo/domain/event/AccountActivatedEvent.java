package com.example.springbootaxomframeworkdemo.domain.event;


import com.example.springbootaxomframeworkdemo.domain.Status;
import lombok.Data;

@Data
public class AccountActivatedEvent extends BaseEvent<String> {
    private Status status;

    public AccountActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}

