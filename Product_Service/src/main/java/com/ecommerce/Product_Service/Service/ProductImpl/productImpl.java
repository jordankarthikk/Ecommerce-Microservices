package com.ecommerce.Product_Service.Service.ProductImpl;

import com.ecommerce.Product_Service.Entity.Product;
import com.ecommerce.Product_Service.Repository.ProductRepository;
import com.ecommerce.Product_Service.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class productImpl implements ProductService {

    @Autowired
    private  ProductRepository productRepository ;

//    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));
    }
    @Override
    public void reduceStock(Long productId,
                            Integer quantity) {

        Product product =
                productRepository.findById(productId)
                        .orElseThrow();

        product.setStock(
                product.getStock() - quantity
        );

        productRepository.save(product);
    }
}
