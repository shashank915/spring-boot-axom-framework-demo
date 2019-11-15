package com.example.springbootaxomframeworkdemo.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseEvent<T> {

    private T id;
}
