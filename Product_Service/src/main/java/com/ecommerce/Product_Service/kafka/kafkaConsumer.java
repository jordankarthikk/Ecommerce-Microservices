package com.ecommerce.Product_Service.kafka;

import com.ecommerce.common.dto.ProductDTO;
import com.ecommerce.Product_Service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaConsumer {


    @Autowired
    private ProductService productService;

    @KafkaListener(topics = "order-topic3", groupId = "product-group")
    public void consume(ProductDTO product) {

        productService.reduceStock(product.getId(), product.getStock());

    }
}