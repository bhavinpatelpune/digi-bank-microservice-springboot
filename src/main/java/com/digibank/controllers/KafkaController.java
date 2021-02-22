package com.digibank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import com.digibank.dtos.Book;
import com.digibank.services.ProducerKafka;

//@RestController
//public class KafkaController {
//	
//	@Autowired
//	KafkaTemplate<String,Book> kafkaTemplate;
//
//    private static final String TOPIC = "TestTopic";
//    @PostMapping("/publish")
//    public String publishMessage(@RequestBody Book book){
//        kafkaTemplate.send(TOPIC,book);
//        return  "published";
//    }
//
//}


@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final ProducerKafka producer;

    @Autowired
    KafkaController(ProducerKafka producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }
}