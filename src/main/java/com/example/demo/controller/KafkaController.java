package com.example.demo.controller;

import com.example.demo.service.KafkaConsumerService;
import com.example.demo.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService producerService;
    private final KafkaConsumerService consumerService;

    public KafkaController(KafkaProducerService producerService, KafkaConsumerService consumerService) {
        this.producerService = producerService;
        this.consumerService = consumerService;
    }

    @PostMapping("/publish")
    public String publish(@RequestParam("message") String message) {
        producerService.sendMessage("my-topic", message);
        return "Message sent to Kafka topic 'my-topic': " + message;
    }

    @GetMapping("/messages")
    public List<String> getMessages() {
        return consumerService.getConsumedMessages();
    }
}
