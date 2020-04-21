package com.naturecode.kafka_spring.consumer;

import java.time.ZonedDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.util.concurrent.RateLimiter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumer {
  private static final Logger LOG = LoggerFactory.getLogger(KafKaConsumer.class);
  RateLimiter rateLimiter = RateLimiter.create(10);
  AtomicInteger counter = new AtomicInteger(1);

  @KafkaListener(topics = "${kafka.topic.name}", groupId = "my-son")
  public void listen(@Payload String message, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key) {
    if(counter.get() % 50 == 0){
      rateLimiter.setRate(rateLimiter.getRate()/2);
    }
    rateLimiter.acquire(1);
    counter.incrementAndGet();
    LOG.info("'{}-{}' at {} with {}", key, message, ZonedDateTime.now());   
  }
}