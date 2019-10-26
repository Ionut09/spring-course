package com.spring.gameloft.configuration.impl;

import com.spring.gameloft.configuration.MessageProvider;

public class HelloGameloftMessagProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello Java programmers from Gameloft";
    }
}