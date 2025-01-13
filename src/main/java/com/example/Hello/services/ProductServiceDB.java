package com.example.Hello.services;


import com.example.Hello.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceDB implements IProductService {

    @Override
    public Product ReplaceProduct(Product product, long Id) {
        return null;
    }

    @Override
    public Product DeleteProduct(long Id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }



}
