package com.charroux.stream;

import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.Message;
import com.rabbitmq.stream.Producer;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class EventPublisher {

    private static AtomicInteger idGenerator = new AtomicInteger(1);

    Producer producer;

    public EventPublisher(){
        Environment environment = Environment.builder().uri("rabbitmq-stream://localhost:5552").build();
        environment.streamCreator().stream("first-application-stream").create();
        producer = environment.producerBuilder().stream("first-application-stream").build();
    }

    public void publish(byte[] data){
        Message message = producer
                .messageBuilder()
                .properties()
                .creationTime(System.currentTimeMillis())
                .messageId(idGenerator.incrementAndGet())
                .messageBuilder()
                .addData(data)
                .build();

        CountDownLatch publishConfirmLatch = new CountDownLatch(1);

        new Thread(() -> producer.send(message, confirmationStatus -> publishConfirmLatch.countDown())).start();

        try {
            publishConfirmLatch.await(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
