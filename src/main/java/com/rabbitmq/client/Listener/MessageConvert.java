package com.rabbitmq.client.Listener;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.rabbitmq.client.vo.QueueMessage;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageConvert{
    QueueMessage queueMessage = new QueueMessage();
    ObjectMapper objectMapper = new ObjectMapper();

    public MessageConvert() {
    }

    public QueueMessage getQueueMessage(Message message) throws Exception {

        byte[] b = message.getBody();

        String qm = objectMapper.readValue(new String(b),String.class);
        queueMessage = objectMapper.readValue(qm,  QueueMessage.class);

        return queueMessage;
    }
    public QueueMessage stringToQueueMessage(String msg) throws Exception{
        queueMessage = objectMapper.readValue(msg,QueueMessage.class);
        return queueMessage;
    }
}
