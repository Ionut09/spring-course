package com.spring.gameloft.configuration.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = {"com.spring.gameloft.configuration.annotation.impl"})
//@ImportResource("app-context.xml") //pentru a adauga o configurare mai veche deja facuta in xml
public class AnotationConfig {
}