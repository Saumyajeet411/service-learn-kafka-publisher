package com.learn.app.controller;

import com.learn.app.model.User;
import com.learn.app.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/json", consumes = "application/json", produces = "application/json")
    public String publishJson(@RequestBody User user) {
        producerService.sendMessage(defaultTopic, user);
        return "User " + user.getName() + " sent";
    }
}
