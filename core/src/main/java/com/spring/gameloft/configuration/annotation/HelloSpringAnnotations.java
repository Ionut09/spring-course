package com.spring.gameloft.configuration.annotation;

import com.spring.gameloft.configuration.MessageRenderer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloSpringAnnotations {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AnotationConfig.class);
        MessageRenderer renderer = ctx.getBean(MessageRenderer.class);
        renderer.render();
    }
}
