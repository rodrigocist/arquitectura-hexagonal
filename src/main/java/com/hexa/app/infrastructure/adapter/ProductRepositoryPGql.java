package com.hexa.app.infrastructure.adapter;

import com.hexa.app.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepositoryPGql extends JpaRepository<ProductEntity, Long> {
}
