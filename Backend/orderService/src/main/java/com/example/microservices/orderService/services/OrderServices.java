package com.example.microservices.orderService.services;

import com.example.microservices.orderService.dto.OrderDTO;
import com.example.microservices.orderService.model.Order;
import com.example.microservices.orderService.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServices {
    @Autowired
    private OrderRepo orderRepo;

    public void postOrder(OrderDTO order) {
        Order saveData = new Order();
        saveData.setOrderNumber(UUID.randomUUID().toString());
        saveData.setQuantity(order.getQuantity());
        saveData.setPrice(order.getPrice());
        saveData.setSKUCode(order.getSkuCode());
        System.out.println(order);
        orderRepo.save(saveData);
    }
}
