package com.rabbitmq.client.Listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.vo.QueueMessage;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private ObjectMapper objectMapper = new ObjectMapper();

    public void receive(String message) throws JsonProcessingException {
        QueueMessage getQueueMessage = objectMapper.readValue(message, QueueMessage.class);

        System.out.println(getQueueMessage.getId()+"번 주문이 도착했습니다.");
    }
}
