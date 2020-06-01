package com.rabbitmq.client.Listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.vo.Message;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    //private ObjectMapper objectMapper = new ObjectMapper();

    public void receive(String message) throws JsonProcessingException {
        //Message getMessage = objectMapper.readValue(message,Message.class);

        System.out.println("번 주문이 도착했습니다.");
    }
}
