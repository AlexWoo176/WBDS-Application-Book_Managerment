package com.codegym.services.product;

import com.codegym.models.Product;
import com.codegym.models.ProductForm;
import com.codegym.services.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService extends IService<Product> {
    List<Product> findAll();

    Page<Product> findById(Pageable pageable);

    Optional<Product> findById(Long id);

    void save(ProductForm productForm);

    void add(Product product);

    Product exchangeObject(ProductForm productForm);

    Page<Product> findAllByNameContaining(String name, Pageable pageable );
}
