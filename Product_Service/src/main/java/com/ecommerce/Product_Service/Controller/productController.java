package com.ecommerce.Product_Service.Controller;
import com.ecommerce.Product_Service.Entity.Product;
import com.ecommerce.Product_Service.Service.ProductImpl.productImpl;
import com.ecommerce.Product_Service.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class productController {

    private final ProductService service;

    @PostMapping("/create")
    public ResponseEntity<Product>  create (@RequestBody Product product){

        Product pro = service.create(product);

        return new ResponseEntity<>(pro, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){

        Product pId = service.getById(id);
        return ResponseEntity.ok(pId);
    }

//    @GetMapping("/{id}")
//    public Product getProduct(@PathVariable Long id) {
//
//        return new Product(
//                id,
//                "Laptop",
//                50000.0,
//                10
//        );
//    }
    @PutMapping("/{id}/reduce-stock/{qty}")
    public void reduceStock(
            @PathVariable Long id,
            @PathVariable Integer qty) {

        service.reduceStock(id, qty);
    }
}
