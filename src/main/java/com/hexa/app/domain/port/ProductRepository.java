package com.hexa.app.domain.port;

import com.hexa.app.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getProducts();
    Product getProduct (Long id);
    Product saveProduct (Product product);
    Product updateProduct (Product product);
    String deleteProductById(Long id);
}
