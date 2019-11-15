package com.example.springbootaxomframeworkdemo.service;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountQueryServiceImpl implements AccountQueryService {


    @Autowired
    private EventStore eventStore;

    @Override
    public List<Object> listEventsForAccount(String accountNumber) {
        return eventStore.readEvents(accountNumber).asStream()
                .map(s -> s.getPayload()).collect(Collectors.toList());
    }
}
