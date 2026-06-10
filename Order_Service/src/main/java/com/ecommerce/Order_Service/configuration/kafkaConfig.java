package com.ecommerce.Order_Service.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class kafkaConfig {

    @Bean
    public NewTopic orderTopic() {
        return new NewTopic("order-topic3", 1, (short) 1);
    }
}
