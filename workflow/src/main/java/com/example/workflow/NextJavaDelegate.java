package com.example.workflow;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.context.Context;
import org.camunda.bpm.engine.impl.jobexecutor.JobExecutorContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class NextJavaDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.err.println("NextJavaDelegate");
        delegateExecution.setVariable("count", Long.valueOf(1));
    }
}
