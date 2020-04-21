package com.naturecode.kafka_spring.producer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.util.StringUtils;

// @Configuration
// // @ConfigurationProperties(prefix = "kafka")
// public class KafkaTopicConfig {
//   // @Bean
//   // public KafkaAdmin kafkaAdmin() {
//   // Map<String, Object> configs = new HashMap<>();
//   // System.out.println(bootstrapAddress);
//   // configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//   // return new KafkaAdmin(configs);
//   // }

//   // @Bean
//   // public KafkaAdmin admin() {
//   //   Map<String, Object> configs = new HashMap<>();
//   //   configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//   //   return new KafkaAdmin(configs);
//   // }

//   @Bean
//   public NewTopic createTopic() {
//     return new NewTopic("ponyTopic", 1, (short) 1);
//   }
// }