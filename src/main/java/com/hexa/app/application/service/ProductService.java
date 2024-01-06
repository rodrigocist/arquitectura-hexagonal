package com.hexa.app.application.service;

import com.hexa.app.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    List<Product> getProducts();
    Product getProductById (Long id);
    Product saveProduct (Product product);
    Product updateProduct (Product product);
    String deleteProduct(Long id);
}
