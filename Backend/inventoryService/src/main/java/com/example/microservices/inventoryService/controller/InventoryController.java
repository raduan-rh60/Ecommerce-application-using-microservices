package com.example.microservices.inventoryService.controller;

import com.example.microservices.inventoryService.model.Inventory;
import com.example.microservices.inventoryService.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> listOfData(){
        List<Inventory> allData = inventoryService.getAll();
        return new ResponseEntity<>(allData,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Inventory> saveData(@RequestBody Inventory inventory){
        Inventory savedData = inventoryService.saveData(inventory);
        return new ResponseEntity<>(savedData,HttpStatus.OK);
    }
}
