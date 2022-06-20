package com.example.problem1.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Shipment {
    private String orderId;
    private String shipmentId;
    private String productId;
    private LocalDate shipmentDate;
    private Double qty;
}
