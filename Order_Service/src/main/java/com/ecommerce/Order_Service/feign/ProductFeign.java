package com.ecommerce.Order_Service.feign;

import com.ecommerce.common.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductFeign {

    @GetMapping("/products/{id}")
    ProductDTO getProduct(@PathVariable Long id);

    @PutMapping("/products/{id}/reduce-stock/{qty}")
    void reduceStock(
            @PathVariable Long id,
            @PathVariable Integer qty
    );
}

