package com.example.Hello.services;
import com.example.Hello.Client3p.FakestoreProductservice;
import com.example.Hello.dtos.Categorydto;
import com.example.Hello.dtos.FakestoreProductdto;
import com.example.Hello.dtos.Productdto;
import com.example.Hello.models.Category;
import com.example.Hello.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class ProductService3p implements IProductService
{
    private FakestoreProductservice fakestoreProductservice;

    public ProductService3p(FakestoreProductservice fakestoreProductservice) {
        this.fakestoreProductservice = fakestoreProductservice;
    }

    @Override
    public List<Product> getAllProducts(){
        return fakestoreProductservice.getAllProducts();
    }

    @Override
    public Product getProductById(long id){
        return fakestoreProductservice.getProductById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }


    @Override
    public Product ReplaceProduct(Product product,long Id){
        return fakestoreProductservice.ReplaceProduct(product,Id);
    }





    }



