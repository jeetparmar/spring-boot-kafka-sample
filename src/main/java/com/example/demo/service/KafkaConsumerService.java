package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
    private final List<String> consumedMessages = new CopyOnWriteArrayList<>();

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(String message) {
        logger.info("Consumed: {}", message);
        consumedMessages.add(message);
    }

    public List<String> getConsumedMessages() {
        return new ArrayList<>(consumedMessages);
    }

    public void clearMessages() {
        consumedMessages.clear();
    }
}
