package com.example.productservice.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "age")
@EqualsAndHashCode(exclude = "age")
public class LombokDemo {

    private int age;
    private String name;
    private String address;
}