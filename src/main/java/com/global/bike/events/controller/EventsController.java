package com.global.bike.events.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.bike.events.entity.Sale;
import com.global.bike.events.repo.EventsRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1")
public class EventsController {

    @Autowired
    private EventsRepo repo;

    @PostMapping("/sale")
    public void saveSales(@RequestBody Sale s) {
        repo.save(s);
    }

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "test", groupId = "group1")
    public void consumeBikeSales(ConsumerRecord<String, String> record) throws JsonProcessingException {

        Sale s = objectMapper.readValue(record.value(), Sale.class);
        repo.save(s);
    }
}
