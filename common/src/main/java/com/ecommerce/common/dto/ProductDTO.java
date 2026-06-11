package com.ecommerce.common.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private Integer stock;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

}

