package com.learn.app.controller;

import com.learn.app.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class KafkaController {

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;

    private final KafkaProducerService producerService;

    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public String publish(@RequestParam String message) {
        producerService.sendMessage(defaultTopic, "Message: " + message);
        return "Message sent: " + message;
    }
}
