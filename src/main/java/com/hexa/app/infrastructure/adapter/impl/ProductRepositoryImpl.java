package com.hexa.app.infrastructure.adapter.impl;

import com.hexa.app.domain.model.Product;
import com.hexa.app.domain.port.ProductRepository;
import com.hexa.app.domain.util.Constants;
import com.hexa.app.domain.util.Properties;
import com.hexa.app.infrastructure.adapter.ProductRepositoryPGql;
import com.hexa.app.infrastructure.entity.ProductEntity;
import com.hexa.app.infrastructure.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductRepositoryPGql productRepositoryPGql;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    Properties properties;

    @Override
    public List<Product> getProducts() {
        List<Product> products;
        try{
            List<ProductEntity> productEntities = productRepositoryPGql.findAll();
            products = productEntities
                    .stream()
                    .map(p -> modelMapper.map(p, Product.class))
                    .collect(Collectors.toList());
        }catch (ResourceNotFoundException e){
            throw  new ResourceNotFoundException(properties.getMessage(Constants.ErrorMessage.ERROR_GETTING_DATA.toString()));
        }
        return products;
    }


    
    @Override
    public Product getProduct(Long id) {
        ProductEntity productEntity;
        try{
             productEntity = productRepositoryPGql.findById(id).orElseThrow(
                     ResourceNotFoundException::new
            );
            return Optional.of(modelMapper.map(productEntity, Product.class)).get();
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(properties.getMessage(Constants.ErrorMessage.ERROR_GETID_DATA.toString()));
        }

    }

    @Override
    public Product saveProduct(Product product) {
        try{
            ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
            log.info("save product code {}", productEntity.getCode());
            return modelMapper.map(productRepositoryPGql.save(productEntity), Product.class);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(properties.getMessage(Constants.ErrorMessage.ERROR_SAVING_DATA.toString()));
        }
    }

    @Override
    public Product updateProduct(Product product) {
        try{
            productRepositoryPGql.findById(product.getId()).orElseThrow(
                    ResourceNotFoundException::new
            );
            ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
            log.info("update product code {}", productEntity.getCode());
            return modelMapper.map(productRepositoryPGql.save(productEntity), Product.class);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(properties.getMessage(Constants.ErrorMessage.ERROR_UPDATE_DATA.toString()));

        }
    }

    @Override
    public String deleteProductById(Long id) {
        try {
            ProductEntity productEntity = productRepositoryPGql.findById(id).orElseThrow(
                    ResourceNotFoundException::new
            );
            productRepositoryPGql.deleteById(productEntity.getId());
            return "Delete Sucessful";
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(properties.getMessage(Constants.ErrorMessage.ERROR_DELETE_DATA.toString()));
        }
    }

}
