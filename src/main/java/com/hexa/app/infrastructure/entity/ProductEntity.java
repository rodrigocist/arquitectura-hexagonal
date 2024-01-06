package com.hexa.app.infrastructure.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductEntity extends DateTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String code;
    @Size(min = 4, max = 50, message = "Nombre de producto debe contener al menos 5 caracteres")
    @NotBlank(message = "Nombre de producto no debe estar en blanco")
    private String name;
    @NotBlank(message = "Descripción de producto no debe estar vacío")
    private String description;
    private String urlImage;
    @NotNull(message = "Precio de producto es requerido")
    @Positive(message = "Precio no debe ser un número negativo o cero")
    private Double price;
}
