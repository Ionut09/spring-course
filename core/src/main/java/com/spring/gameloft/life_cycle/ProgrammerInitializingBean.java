package com.spring.gameloft.life_cycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProgrammerInitializingBean implements InitializingBean {
    public static final String DEFAULT_NAME = "John Doe";
    private int age = Integer.MIN_VALUE;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");
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
        ctx.load("classpath:app-context-intializing-bean.xml");
        ctx.refresh();
        ProgrammerInitializingBean ctxBean = (ProgrammerInitializingBean) ctx.getBean("initializingBean");
        ProgrammerInitializingBean ctxBean1 = (ProgrammerInitializingBean) ctx.getBean("initializingBean1");
        ProgrammerInitializingBean ctxBean2 = (ProgrammerInitializingBean) ctx.getBean("initializingBean2");
        ctx.close();
    }
}
