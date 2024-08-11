package com.lengper.cap2024.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    public String determineDetailHeader(String status) {
        if (status.equals("CART")) {
            return "Cart";
        } else {
            return "Order Details";
        }
    }
}