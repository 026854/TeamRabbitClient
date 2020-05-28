package com.rabbitmq.client.config;

import com.rabbitmq.client.publisher.Client;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    private static final String HIGH_QUEUE_NAME = "high-queue";
    private static final String NORMAL_QUEUE_NAME = "normal-queue";
    private static final String DIRECT_EXCHANGE_NAME = "direct-exchange";

    @Bean
    DirectExchange exchange(){
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    @Bean
    public Client client(){ return new Client();}

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                  MessageConverter messageConverter){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return  rabbitTemplate;
    }


}
