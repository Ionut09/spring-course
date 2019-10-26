package com.spring.gameloft.configuration.java;

import com.spring.gameloft.configuration.MessageProvider;
import com.spring.gameloft.configuration.MessageRenderer;
import com.spring.gameloft.configuration.impl.HelloGameloftMessagProvider;
import com.spring.gameloft.configuration.impl.StandardOutMessageRenderer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class HelloGameloftConfig {

    // equivalent of  <bean id="messageProvider"
    // class="com.spring.gameloft.configuration.impl.HelloGameloftMessagProvider"/>
    @Bean(name = "messageProvider")
    //@Qualifier("messageProvider")
    public MessageProvider messageProvider() { //default beanul va avea numele metodei
        return new HelloGameloftMessagProvider();
    }

    @Bean
    @Order(1)
    public MessageRenderer messageRenderer() {
        return new StandardOutMessageRenderer(messageProvider());
    }
    @Bean
    @Order(2)
    public MessageRenderer messageRenderer1() {
        return new StandardOutMessageRenderer(messageProvider());
    }
    @Bean
    public MessageRenderer messageRenderer2() {
        return new StandardOutMessageRenderer(messageProvider());
    }
    @Bean
    public MessageRenderer messageRenderer3() {
        return new StandardOutMessageRenderer(messageProvider());
    }
}
