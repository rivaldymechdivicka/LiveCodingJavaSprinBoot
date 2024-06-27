package com.example.buyItem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.buyItem.services.OrderService;
import com.example.buyItem.dto.OrderRequest;
import com.example.buyItem.models.OrderModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public OrderModel createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/orders")
    public List <OrderModel> getAllOrders() {
        return orderService.getAllOrders();
    }
    
}
