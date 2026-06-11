package com.ecommerce.Order_Service.Controller;

import com.ecommerce.Order_Service.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class orderController {

    @Autowired
    private OrderService orderService;

    @Value("${msg:Default Message}")
    public String message;

    @GetMapping("/msg")
    public String msg(){

        return message;
    }
    @PostMapping("/{productId}/{quantity}")
    public String placeOrder(
            @PathVariable Long productId,
            @PathVariable Integer quantity) {

        return orderService.createOrder(
                productId,
                quantity
        );
    }
}