package com.hexa.app.application.service.impl;

import com.hexa.app.application.service.ProductService;
import com.hexa.app.domain.model.Product;
import com.hexa.app.domain.port.ProductRepository;
import com.hexa.app.infrastructure.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomainProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public Product getProductById(Long id) {

       // return productRepository.getProduct(id).ifPresent().get();
        return productRepository.getProduct(id);

    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }


    @Override
    public Product updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    @Override
    public String deleteProduct(Long id) {
        return productRepository.deleteProductById(id);
    }
}
