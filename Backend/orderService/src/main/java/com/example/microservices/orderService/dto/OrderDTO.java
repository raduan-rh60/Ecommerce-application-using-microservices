package com.example.microservices.orderService.dto;

import lombok.Data;

@Data
public class OrderDTO {
    double price;
    String skuCode;
    int quantity;
}
