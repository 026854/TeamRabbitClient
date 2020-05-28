package com.rabbitmq.client.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.vo.Message;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Client {

    @Autowired
    private Exchange exchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    AtomicInteger index = new AtomicInteger(0);
    private ObjectMapper objectMapper = new ObjectMapper();

    
    
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() throws JsonProcessingException {
        //StringBuilder builder = new StringBuilder(this.index.incrementAndGet());
        StringBuilder builder = new StringBuilder("");
        builder.append(this.index.incrementAndGet());


        //랜덤 키 생성
        Random random = new Random();
        String key;
        if(random.nextBoolean()){
            key = "high";
        }else{
            key = "normal";
        }

        //Message message = new Message(builder.toString())
        Message message = new Message("C:\\Users\\user\\Desktop\\daou", 10, "doc", "pdf",builder.toString());
        String jsonMessage = objectMapper.writeValueAsString(message);

        //String json = objectMapper.writeValueAsString(message);
        rabbitTemplate.convertAndSend(exchange.getName(), key, jsonMessage);
        System.out.println(" [x] Sent to "+exchange.getName()+" "+key+"  '" +message.getId()  + "'");



    }
}
