package com.spring.gameloft.life_cycle;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

public class ProgrammerPostConstruct {
    public static final String DEFAULT_NAME = "John Doe";
    private int age = Integer.MIN_VALUE;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initializing bean with @PostConstruct");
        if (age == Integer.MIN_VALUE) {
            throw new RuntimeException(
                    "You must set age properrty of beans " + this.getClass().getSimpleName());
        }
        if (name == null) {
            System.out.println("setting default name");
            name = DEFAULT_NAME;
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-post-construct.xml");
        ctx.refresh();
        ProgrammerPostConstruct ctxBean = (ProgrammerPostConstruct) ctx.getBean("postConstructBean");
        ProgrammerPostConstruct ctxBean1 = (ProgrammerPostConstruct) ctx.getBean("postConstructBean1");
        ProgrammerPostConstruct ctxBean2 = (ProgrammerPostConstruct) ctx.getBean("postConstructBean2");
        System.out.println(ctxBean2.name);
        ctx.close();

    }
}
