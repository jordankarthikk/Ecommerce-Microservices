package com.ecommerce.Order_Service.Service;


//import com.ecommerce.Order_Service.feign.ProductFeign;
import com.ecommerce.common.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OrderService {


//    @Autowired
//    private ProductFeign productFeign;

//    @Autowired
//    private RestTemplate restTemplate;
//
    @Autowired
    private WebClient webClient;

    @Autowired
    private KafkaTemplate<String, ProductDTO> kafkaTemplate;

    public String createOrder(Long productId, Integer quantity) {
//        feign client
//        ProductDTO product =
//                productFeign.getProduct(productId);
//rest template
//        String url= "http://localhost:2222/products/" + productId;
//       ProductDTO product = restTemplate.getForObject(url,ProductDTO.class);
// webclient
        ProductDTO product = webClient
                .get()
                .uri("/products/{id}", productId)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();


        if (product.getStock() < quantity) {
            return "Insufficient Stock";
        }

        double totalPrice =
                product.getPrice() * quantity;

//        feign client
//        productFeign.reduceStock(productId, quantity);

        //resttemplate
//        String url2 =
//                "http://localhost:2222/products/"
//                        + productId
//                        + "/reduce-stock/"
//                        + quantity;
//
//        restTemplate.put(url2, null);

        //Webclient

//        webClient
//                .put()
//                .uri("/products/{id}/reduce-stock/{qty}",
//                        productId,
//                        quantity)
//                .retrieve()
//                .bodyToMono(Void.class)
//                .block();
        ProductDTO p =new ProductDTO();
        p.setId(productId);
        p.setStock(quantity);

        kafkaTemplate.send("order-topic3",p);

        return "Order Created Successfully. Total Amount = "
                + totalPrice;

    }


}
