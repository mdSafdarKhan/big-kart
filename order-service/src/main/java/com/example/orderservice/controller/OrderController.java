package com.example.orderservice.controller;

import com.example.orderservice.model.OrderRequest;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createProduct(@RequestBody OrderRequest orderRequest){
        if(orderService.createOrder(orderRequest) != null){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        else{
            throw new OrderNotCreatedException();
        }
    }

    @GetMapping
    public ResponseEntity<Boolean> isOrderPresent(@RequestParam Integer id){
        return ResponseEntity.ok().body(orderService.isOrderPresent(id));
    }

    public static class OrderNotCreatedException extends RuntimeException {
    }
}
