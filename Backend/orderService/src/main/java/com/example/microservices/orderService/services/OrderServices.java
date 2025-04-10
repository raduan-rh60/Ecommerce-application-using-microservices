package com.example.microservices.orderService.services;

import com.example.microservices.orderService.client.InventoryClient;
import com.example.microservices.orderService.dto.OrderDTO;
import com.example.microservices.orderService.model.Order;
import com.example.microservices.orderService.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServices {

    private OrderRepo orderRepo;
    private InventoryClient inventoryClient;

    public void postOrder(OrderDTO order) {
        boolean isProductInStock = inventoryClient.isInStock(order.getSkuCode(),order.getQuantity());

        if(isProductInStock){
            Order saveData = new Order();
            saveData.setOrderNumber(UUID.randomUUID().toString());
            saveData.setQuantity(order.getQuantity());
            saveData.setPrice(order.getPrice());
            saveData.setSKUCode(order.getSkuCode());
            System.out.println(order);
            orderRepo.save(saveData);
        }else {
           throw new RuntimeException("Product with SKU Code"+order.getSkuCode()+"Is out of Stock");
        }

    }
}
