package com.example.workflow;

import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * trigger a message start event
 * curl -X POST -H "Content-Type: application/json" -d '{"messageName":"filesAcceptedMessage","processInstanceId":"49532f3e-d58f-11eb-bb8c-1a3c72320596"}' http://localhost:8080/engine-rest/message
 */
@Configuration
public class WorkflowBeans {

    @Bean
    public JavaDelegate download() {
        return execution -> System.out.println("Download files{id="+execution.getProcessInstanceId()+"}");
    }

    @Bean
    public JavaDelegate sendZip() {
        return execution -> System.out.println("Send Zip{id="+execution.getProcessInstanceId()+"}");
    }

    @Bean
    public JavaDelegate zip() {
        return execution -> System.out.println("Zipping{zipFile=flag_daily_20210622_20210623T002523.zip, id="+ execution.getProcessInstanceId()+ "}");
    }
}
