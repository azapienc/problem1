package com.example.problem1.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private String orderId;
    private String productId;
    private Double qty;

}
