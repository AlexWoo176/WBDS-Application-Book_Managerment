package com.codegym.services.product;

import com.codegym.models.Product;
import com.codegym.models.ProductForm;
import com.codegym.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ProductService implements IProductService {
    @Autowired
    Environment env;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Page<Product> findById(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productRepository.findOne(id));
    }

    @Override
    public void save(Product model) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void save(ProductForm productForm) {
        Product product = exchangeObject(productForm);
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product exchangeObject(ProductForm productForm) {
        String fileName;
        if (productForm.getImage().equals("")) {
            fileName = productRepository.findOne(productForm.getId()).getImage();
        } else {
            MultipartFile multipartFile = productForm.getImage();
            fileName = multipartFile.getOriginalFilename();
        }
        String folderContaintFileStore = env.getProperty("");

        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(folderContaintFileStore + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Product product = new Product(productForm.getId(), productForm.getName(),
                productForm.getPrice(), fileName,productForm.getDescription(), productForm.getAuthor());
        return product;
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name, pageable);
    }
}
