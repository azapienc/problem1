package com.example.problem1.Services;

import com.example.problem1.Models.Order;
import com.example.problem1.Models.Shipment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@Slf4j
public class ShipmentService {

    Shipment shipment = new Shipment("Order 1","Ship1","Prod1", LocalDate.of(2021, Month.FEBRUARY, 9) ,2.0);

    public Shipment findShipment(){
        log.info("Getting shipment");
        return this.shipment;
    }
}


