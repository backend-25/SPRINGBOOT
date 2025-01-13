package com.example.Hello.services;

import com.example.Hello.models.Product;

import java.util.List;

public interface IProductService
{
    List<Product> getAllProducts();
    Product getProductById(long id);

    Product createProduct(Product product);
    Product ReplaceProduct(Product product,long Id);
    Product DeleteProduct(long Id);


}
