package com.global.bike.events.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {

        Map<String, Object> configs = new HashMap<>();

        //for cloudkarafka
//        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"moped.srvs.cloudkafka.com:9094");
//        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
//        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
//        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
//        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configs.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG,"SASL_SSL");
//        configs.put(SaslConfigs.SASL_MECHANISM,"SCRAM-SHA-256");
//        configs.put(SaslConfigs.SASL_JAAS_CONFIG,"org.apache.kafka.common.security.scram.ScramLoginModule required username=\"wxufrcab\" password=\"VlBsxcBLwMxYuqQY1wrqwN10YDwlzE8b\";");

        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");

        return new DefaultKafkaConsumerFactory<>(configs);
    }

}
