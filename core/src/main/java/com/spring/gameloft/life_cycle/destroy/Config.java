package com.spring.gameloft.life_cycle.destroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Config.class)
public class Config {

    @Bean
    public String filePath() {
        return "text_file.txt";
    }
}