package com.example.orderservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "product_order", catalog = "msd")
public class Order {

    @Id
    @Column(name = "id")
    Integer id;

    @Column(name = "user_id")
    int userId;

    @Embedded
    ProductDetail productDetail;

    @Column(name = "quantity")
    int quanity;

    @Column(name = "address")
    String address;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Embeddable
    public static class ProductDetail {

        @Column(name = "code")
        int code;

        @Column(name = "name")
        String name;

        @Column(name = "description")
        String description;
    }
}