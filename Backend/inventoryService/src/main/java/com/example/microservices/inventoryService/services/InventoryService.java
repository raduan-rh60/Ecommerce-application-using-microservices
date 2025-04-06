package com.example.microservices.inventoryService.services;

import com.example.microservices.inventoryService.repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    public boolean isAvailable(String skuCode , int quantity){
      return  inventoryRepo.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
    }
}
