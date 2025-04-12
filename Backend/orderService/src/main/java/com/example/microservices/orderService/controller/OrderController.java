package com.example.microservices.orderService.controller;

import com.example.microservices.orderService.dto.OrderDTO;
import com.example.microservices.orderService.model.Order;
import com.example.microservices.orderService.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @PostMapping("/save")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDTO order){
        orderServices.postOrder(order);
        return new ResponseEntity<>("Order Save Successfully", HttpStatus.OK);
    }
}
