package com.example.problem1.Services;

import com.example.problem1.Models.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    Order order = new Order("Order1", "Prod1", 2.0);

    public Order findOrder(){
        log.info("Getting order");
        return this.order;
    }

}
