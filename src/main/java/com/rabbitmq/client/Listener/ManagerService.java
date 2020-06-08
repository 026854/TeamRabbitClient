package com.rabbitmq.client.Listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.vo.QueueMessage;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private MessageConvert messageConvert = new MessageConvert();

    public void receive(Message message) throws Exception {
        QueueMessage queueMessage = messageConvert.getQueueMessage(message);

        System.out.println(queueMessage.getId()+"번 주문이 도착했습니다.");
    }
}
