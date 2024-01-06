package com.hexa.app.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
public class Product {
    private Long id;
    private  String code;
    private String name;
    private String description;
    private String urlImage;
    private Double price;

    public Product() {
        this.code = UUID.randomUUID().toString();
    }
}
