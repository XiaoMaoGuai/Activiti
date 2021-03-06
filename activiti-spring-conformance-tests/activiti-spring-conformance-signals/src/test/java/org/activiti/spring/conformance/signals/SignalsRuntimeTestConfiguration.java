package org.activiti.spring.conformance.signals;

import org.activiti.api.model.shared.event.RuntimeEvent;
import org.activiti.api.process.model.events.BPMNActivityCompletedEvent;
import org.activiti.api.process.model.events.BPMNActivityStartedEvent;
import org.activiti.api.process.model.events.BPMNSequenceFlowTakenEvent;
import org.activiti.api.process.model.events.BPMNSignalReceivedEvent;
import org.activiti.api.process.runtime.events.*;
import org.activiti.api.process.runtime.events.listener.BPMNElementEventListener;
import org.activiti.api.process.runtime.events.listener.ProcessRuntimeEventListener;
import org.activiti.api.task.runtime.events.TaskCancelledEvent;
import org.activiti.api.task.runtime.events.TaskCompletedEvent;
import org.activiti.api.task.runtime.events.TaskCreatedEvent;
import org.activiti.api.task.runtime.events.listener.TaskRuntimeEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SignalsRuntimeTestConfiguration {

    public static List<RuntimeEvent> collectedEvents = new ArrayList<>();

    @Bean
    public BPMNElementEventListener<BPMNActivityStartedEvent> bpmnActivityStartedListener() {
        return bpmnActivityStartedEvent -> collectedEvents.add(bpmnActivityStartedEvent);
    }

    @Bean
    public BPMNElementEventListener<BPMNActivityCompletedEvent> bpmnActivityCompletedListener() {
        return bpmnActivityCompletedEvent -> collectedEvents.add(bpmnActivityCompletedEvent);
    }

    @Bean
    public TaskRuntimeEventListener<TaskCreatedEvent> taskCreatedEventListener() {
        return taskCreatedEvent -> collectedEvents.add(taskCreatedEvent);
    }

    @Bean
    public TaskRuntimeEventListener<TaskCompletedEvent> taskCompletedEventListener() {
        return taskCompletedEvent -> collectedEvents.add(taskCompletedEvent);
    }

    @Bean
    public TaskRuntimeEventListener<TaskCancelledEvent> taskCancelledEventTaskRuntimeEventListener(){
        return taskCancelledEvent -> collectedEvents.add(taskCancelledEvent);
    }

    @Bean
    public BPMNElementEventListener<BPMNSequenceFlowTakenEvent> bpmnSequenceFlowTakenListener() {
        return bpmnSequenceFlowTakenEvent -> collectedEvents.add(bpmnSequenceFlowTakenEvent);
    }

    @Bean
    public ProcessRuntimeEventListener<ProcessCreatedEvent> processCreatedListener() {
        return processCreatedEvent -> collectedEvents.add(processCreatedEvent);
    }

    @Bean
    public ProcessRuntimeEventListener<ProcessStartedEvent> processStartedListener() {
        return processStartedEvent -> collectedEvents.add(processStartedEvent);
    }
    
    @Bean
    public ProcessRuntimeEventListener<ProcessCompletedEvent> processCompletedListener() {
        return processCompletedEvent -> collectedEvents.add(processCompletedEvent);
    }
    
    @Bean
    public BPMNElementEventListener<BPMNSignalReceivedEvent> bpmnSignalReceivedListener() {
        return bpmnSignalReceivedEvent -> collectedEvents.add(bpmnSignalReceivedEvent);
    }
    
    
}
