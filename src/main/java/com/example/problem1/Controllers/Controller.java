package com.example.problem1.Controllers;

import com.example.problem1.Models.Order;
import com.example.problem1.Models.Result;
import com.example.problem1.Models.Shipment;
import com.example.problem1.Services.OrderService;
import com.example.problem1.Services.ShipmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RestController
@RequestMapping(path="")
public class Controller {

    private final ExecutorService executorService;
    private final OrderService orderService;
    private final ShipmentService shipmentService;

    Callable<Order> getOrder = new Callable<Order>() {
        @Override
        public Order call() throws Exception {
            System.out.println("getting order");
            return orderService.findOrder();
        }
    };

    Callable<Shipment> getShipment = new Callable<Shipment>() {
        @Override
        public Shipment call() throws Exception {
            return shipmentService.findShipment();
        }
    };

    @Autowired
    public Controller(ExecutorService executorService, OrderService orderService, ShipmentService shipmentService) {
        this.executorService = executorService;
        this.orderService = orderService;
        this.shipmentService = shipmentService;
    }

    @GetMapping(path="getOrderDetails")
    public Result getProduct(@RequestBody String orderId) throws ExecutionException, InterruptedException {

        Future<Order> orderFuture = executorService.submit(getOrder);
        Future<Shipment> shipmentFuture = executorService.submit(getShipment);

        Result result = new Result();
        result.setOrder(orderFuture.get());
        result.setShipment(shipmentFuture.get());

        return result;
    }

}
