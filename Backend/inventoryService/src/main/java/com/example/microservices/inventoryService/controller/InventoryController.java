package com.example.microservices.inventoryService.controller;

import com.example.microservices.inventoryService.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<String> isStock(@RequestParam String skuCode,@RequestParam int quantity){
        boolean result = inventoryService.isAvailable(skuCode,quantity);
        if(result)
        return new ResponseEntity<>("Product Available", HttpStatus.OK);
        else
            return new ResponseEntity<>("Product Not Available", HttpStatus.FORBIDDEN);
    }
}
