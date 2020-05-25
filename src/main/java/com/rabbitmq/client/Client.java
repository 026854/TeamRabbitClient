package com.rabbitmq.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void send() {
        StringBuilder builder = new StringBuilder("index : ");
        builder.append(this.index.incrementAndGet());

        //랜덤 키 생성
        Random random = new Random();
        String key;
        if(random.nextBoolean()){
            key = "high";
        }else{
            key = "normal";
        }

        builder.append(' ').append(key);
        //Message message = new Message(builder.toString());
        String message = builder.toString();

        //String json = objectMapper.writeValueAsString(message);
        rabbitTemplate.convertAndSend(exchange.getName(), key, message);
        System.out.println(" [x] Sent to "+exchange.getName()+" "+key+"  '" + message + "'");



    }
}
