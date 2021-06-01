package com.example.workflow;

import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class WorkflowBeans {

    @Bean
    public JavaDelegate ahoyService() {
        return execution -> System.out.println("\n\n" + new Date() +" Ahoy #1, " + execution.getVariable("count") + "!");
    }

    @Bean
    public JavaDelegate ahoyService2() {
        return execution -> System.out.println("\n\n" + new Date() +" Ahoy #2, " + execution.getVariable("count") + "!");
    }

    @Bean
    public JavaDelegate nonInter() {
        return execution -> System.out.println("\n\n" + new Date() +" nonInter #1, " + execution.getVariable("count") + "!");
    }

    @Bean
    public String timerDuration() {
        return "0/15 * * ? * *";
    }
}
