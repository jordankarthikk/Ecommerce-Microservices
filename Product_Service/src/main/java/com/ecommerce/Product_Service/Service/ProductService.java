package com.ecommerce.Product_Service.Service;


import com.ecommerce.Product_Service.Entity.Product;

public interface ProductService {

        public Product create(Product product);
        public Product getById(Long id);
        public void reduceStock(Long id,Integer quantity);

}
