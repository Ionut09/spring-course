package com.spring.gameloft.configuration.annotation.impl;

import com.spring.gameloft.configuration.MessageProvider;

import org.springframework.stereotype.Component;

@Component("messageProvider")  //helloGameloftMessagProvider default name
public class HelloGameloftMessagProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello Java programmers from Gameloft";
    }
}