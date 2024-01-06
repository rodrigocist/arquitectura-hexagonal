package com.hexa.app.infrastructure.controller;

import com.hexa.app.application.service.ProductService;
import com.hexa.app.domain.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/V_1")
@Slf4j
@Tag(name = "Products API")
public class ProductController {

    @Autowired
    ProductService productService;

    @Operation(summary = "Get all products", description = "Returns all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
    })
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @Operation(summary = "Save product", description = "Returns Response code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully persist"),
            @ApiResponse(responseCode = "404", description = "Error persist")
    })
    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        log.info("Product: {}",product);
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }


    @Operation(summary = "Update product", description = "Returns Response code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully update"),
            @ApiResponse(responseCode = "404", description = "Error update")
    })
    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        log.info("Product: {}",product);
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        log.info("Id "+id);
        log.info("Product {}",productService.getProductById(id));
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id){
        //return (productService.deleteProduct(id), HttpStatus.CREATED);
        return productService.deleteProduct(id);
    }


}
