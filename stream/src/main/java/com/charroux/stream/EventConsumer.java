package com.charroux.stream;

import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.OffsetSpecification;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public abstract class EventConsumer {

    public abstract void handleMessage(byte[] bodyAsBinary) throws IOException;

    public void consume(){

        Environment environment = Environment.builder().uri("rabbitmq-stream://localhost:5552").build();
        AtomicInteger messageConsumed = new AtomicInteger(0);
        long start = System.currentTimeMillis();

        com.rabbitmq.stream.Consumer consumer = environment.consumerBuilder().stream("first-application-stream")
            .offset(OffsetSpecification.first())
            .messageHandler((context, message) -> {
                try {
                    handleMessage(message.getBodyAsBinary());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            })
            .build();

        while(true){}

    }
}
