package com.example.Hello.controllers;
import com.example.Hello.dtos.Categorydto;
import com.example.Hello.dtos.Productdto;
import com.example.Hello.models.Category;
import com.example.Hello.models.Product;
import com.example.Hello.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController
{

    @Autowired
    @Qualifier("DBSERVICE")
    private IProductService myproductservice;


    @PostMapping("")
    public Productdto CreateProduct(@RequestBody Productdto productdto){
        Product product= from(productdto);
        Product NewProduct=myproductservice.createProduct(product);
        return from(NewProduct);
    }

    @GetMapping("")
    public List<Productdto> getAllProducts()
    {
        List<Product> products= myproductservice.getAllProducts();
        List<Productdto> productdtos = new ArrayList<>();
        if(products !=null && !products.isEmpty())
        {
            for(Product product:products)
            {
                productdtos.add(from(product));
            }
            return productdtos;
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productdto> getProductById(@PathVariable("id") long productId)
    {
        if(productId<1 || productId>20)
        {
            throw new RuntimeException("Product not found");
        }
        Product product=myproductservice.getProductById(productId);
        if(product==null) {return null;  }
        return new ResponseEntity<> (from(product), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Productdto ReplaceProduct(@PathVariable("id") long Id,@RequestBody Productdto productdto)
    {
        Product replaceProduct=from(productdto);
        Product replacedProduct=myproductservice.ReplaceProduct(replaceProduct,Id);
        return from(replacedProduct);

    }

    @DeleteMapping("/{id}")
    public Productdto deleteProduct(@PathVariable long id) {
        Product DeletedProduct=myproductservice.DeleteProduct(id);
        return from(DeletedProduct);
    }
















    private Product from (Productdto productdto)
    {
        Product product = new Product();
        product.setId(productdto.getId());
        product.setAmount(productdto.getAmount());
        product.setTitle(productdto.getTitle());
        product.setDescription(productdto.getDescription());
        product.setImageUrl(productdto.getImageurl());
        Category category= new Category();
        category.setName(productdto.getCategorydto().getName());
        category.setDescription(productdto.getCategorydto().getDescription());
        category.setId(productdto.getCategorydto().getId());
        category.setProducts(productdto.getCategorydto().getProducts());
        product.setCategory(category);
        return product;
    }
    private Productdto from (Product product)
    {
        Productdto pDto= new Productdto();
        pDto.setId(product.getId());
        pDto.setTitle(product.getTitle());
        pDto.setImageurl(product.getImageUrl());
        pDto.setAmount(product.getAmount());
        pDto.setDescription(product.getDescription());
        if(product.getCategory()!=null)
        {
            Categorydto categorydto=new Categorydto();
            categorydto.setName(product.getCategory().getName());
            categorydto.setDescription(product.getCategory().getDescription());
            categorydto.setId(product.getCategory().getId());
            pDto.setCategorydto(categorydto);
        }
        return pDto;


    }


}
