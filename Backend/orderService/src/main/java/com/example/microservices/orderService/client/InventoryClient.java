package com.example.microservices.orderService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory",url = "${inventory.url}")
public interface InventoryClient{

    @RequestMapping(method = RequestMethod.GET, value = "api/inventory")
    Boolean isInStock(@RequestParam String skuCode, @RequestParam int quantity);
}
