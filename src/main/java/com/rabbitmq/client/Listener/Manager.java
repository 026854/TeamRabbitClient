package com.rabbitmq.client.Listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class Manager {
    private static final String RESULT_QUEUE_NAME = "result-queue";

    @Autowired
    private ManagerService service;

    @RabbitListener(queues= RESULT_QUEUE_NAME)
    public void resultReceiver(String message) throws InterruptedException, JsonMappingException, JsonProcessingException {
        service.receive(message);
    }
}
