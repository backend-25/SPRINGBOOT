package com.example.Hello.services;


import com.example.Hello.Repos.CategoryRepo;
import com.example.Hello.Repos.ProductRepo;
import com.example.Hello.models.Category;
import com.example.Hello.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("DBSERVICE")
public class ProductServiceDB implements IProductService
{
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    //----------------------------------------------





    @Override
    public Product createProduct(Product product)
    {
        return productRepo.save(product);
    }


    @Override
    public Product getProductById(long id)
    {
        Optional<Product> optionalProduct= productRepo.findById(id);
        if(optionalProduct.isPresent())
        {
            return optionalProduct.get();
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts()
    {
        return productRepo.findAll();
    }

    // Replace (update) a product by ID
    @Override
    public Product ReplaceProduct(Product product, long id)
    {
        // Check if the product with the given ID exists
        Optional<Product> optionalProduct = productRepo.findById(id);

        if (optionalProduct.isPresent())
        {
            Product existingProduct = optionalProduct.get();
            // Update the fields of the existing product
            existingProduct.setTitle(product.getTitle());
            existingProduct.setAmount(product.getAmount());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setImageUrl(product.getImageUrl());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setLastUpdatedAt(new Date());

            return productRepo.save(existingProduct); // Save the updated product
        }
        return null; // Return null if the product does not exist
    }

    @Override
    public Product DeleteProduct(long Id)
    {
        // Check if the product with the given ID exists
        Optional<Product> optionalProduct = productRepo.findById(Id);

        if (optionalProduct.isPresent())
        {
            Product productToDelete = optionalProduct.get();
            productRepo.deleteById(Id); // Delete the product from the database
            return productToDelete;
            // Return the deleted product as confirmation
        }
        return null; // Return null if the product does not exist
    }

    @Override
    public Category getCategoryById(long id)
    {
        Optional<Category> optionalCategory= categoryRepo.findById(id);
        if(optionalCategory.isPresent())
        {
            return optionalCategory.get();
        }
        return null;
    }

}
