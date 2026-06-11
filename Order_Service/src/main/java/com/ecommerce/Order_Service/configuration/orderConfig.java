package com.ecommerce.Order_Service.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class orderConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public WebClient webClient(){

        return WebClient.builder()
                .baseUrl("http://product-service:2222")
//                .baseUrl("http://localhost:2222")
                .build();
    }

}
