package com.example.springbootaxomframeworkdemo.service;

import java.util.List;

public interface AccountQueryService {
    List<Object> listEventsForAccount(String accountNumber);
}
