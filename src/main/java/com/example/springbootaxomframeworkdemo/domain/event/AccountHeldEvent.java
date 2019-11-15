package com.example.springbootaxomframeworkdemo.domain.event;

import com.example.springbootaxomframeworkdemo.domain.Status;
import lombok.Data;

@Data
public class AccountHeldEvent extends BaseEvent<String> {
    private Status status;

    public AccountHeldEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}