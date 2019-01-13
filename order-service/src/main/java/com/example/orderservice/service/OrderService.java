package com.example.orderservice.service;

import com.example.orderservice.controller.OrderController;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderRequest;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;

    public Order createOrder(OrderRequest orderRequest){
        Order order = new OrderTransformer().transform(orderRequest);
        //We must be having timeout
        //Circuit breaking
        //ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity("http://localhost:8081/product?id=" + order.getProductDetail().getCode(), Boolean.class);
        ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity("http://product-service/product?id=" + order.getProductDetail().getCode(), Boolean.class);

        switch (responseEntity.getStatusCode()){
            case OK:
            case CREATED:
            case CONFLICT:
                //do the remediate
                //send back to UI a different formatter model-view
                //send a meaningful error message to UI
        }

        if(responseEntity.getBody()){
            Order saved = orderRepository.save(order);
            return saved;
        }
        else{
            throw new OrderController.OrderNotCreatedException();
        }
    }

    public boolean isOrderPresent(Integer id){
        return orderRepository.findById(id) != null;
    }

    public class OrderTransformer {
        public Order transform(OrderRequest orderRequest) {
            return Order.builder()
                    .id(orderRequest.getId())
                    .userId(orderRequest.getUserId())
                    .quanity(orderRequest.getQuanity())
                    .address(orderRequest.getAddress())
                    .productDetail(Order.ProductDetail.builder()
                            .code(orderRequest.getProductDetail().getCode())
                            .description(orderRequest.getProductDetail().getDescription())
                            .name(orderRequest.getProductDetail().getName())
                            .build())
                    .build();
        }
    }
}
