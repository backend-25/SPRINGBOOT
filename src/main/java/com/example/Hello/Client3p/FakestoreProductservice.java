package com.example.Hello.Client3p;

import com.example.Hello.dtos.FakestoreProductdto;
import com.example.Hello.models.Category;
import com.example.Hello.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakestoreProductservice
{

    private RestTemplate restTemplate;

    public FakestoreProductservice(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

 //API


    public Product createProduct(Product product)
    {

        FakestoreProductdto fakestoreProductdto=from(product);

        FakestoreProductdto fProductdto=RequestForEntity("https://fakestoreapi.com/products",HttpMethod.POST,fakestoreProductdto,FakestoreProductdto.class).getBody();

        return from(fProductdto);
    }



    public List<Product> getAllProducts() {
        FakestoreProductdto[] fakestoreProductdtos;
        fakestoreProductdtos=restTemplate.getForEntity("https://fakestoreapi.com/products",FakestoreProductdto[].class).getBody();

        List<Product> productsList=new ArrayList<>();
        for(FakestoreProductdto fakestoreProductdto:fakestoreProductdtos){
            productsList.add(from(fakestoreProductdto));
        }
        return productsList;
    }


    public Product getProductById(long id)
    {
        ResponseEntity<FakestoreProductdto> fakestoreProductdtoResponseEntity;
        fakestoreProductdtoResponseEntity= restTemplate.getForEntity("https://fakestoreapi.com/products/{myid}",FakestoreProductdto.class,id);
        FakestoreProductdto fakestoreProductdto=fakestoreProductdtoResponseEntity.getBody();
        if(fakestoreProductdtoResponseEntity.getStatusCode().equals(HttpStatusCode.valueOf(200)) && fakestoreProductdto !=null){
            return from(fakestoreProductdto);
        }
        else {
            return null;
        }
    }


    private  <T> ResponseEntity<T> RequestForEntity(String url, HttpMethod method, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException
    {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url,method, requestCallback, responseExtractor, uriVariables);
    }

    public Product ReplaceProduct(Product product,long Id)
    {
        FakestoreProductdto fakestoreProductdto=from(product);

        FakestoreProductdto fProductdto=RequestForEntity("https://fakestoreapi.com/products/{Id}",HttpMethod.PUT,fakestoreProductdto,FakestoreProductdto.class,Id).getBody();

        return from(fProductdto);
    }









    private Product from(FakestoreProductdto fakestoreProductdto)
    {
        Product product = new Product();
        product.setId(fakestoreProductdto.getId());
        product.setAmount(fakestoreProductdto.getPrice());
        product.setTitle(fakestoreProductdto.getTitle());
        product.setDescription(fakestoreProductdto.getDescription());
        product.setImageUrl(fakestoreProductdto.getImage());
        Category category= new Category();
        category.setName(fakestoreProductdto.getCategory());
        product.setCategory(category);
        return product;

    }
    private FakestoreProductdto from (Product product) {
        FakestoreProductdto pDto = new FakestoreProductdto();
        pDto.setId(product.getId());
        pDto.setTitle(product.getTitle());
        pDto.setImage(product.getImageUrl());
        pDto.setPrice(product.getAmount());
        pDto.setDescription(product.getDescription());
        if (product.getCategory() != null) {
            pDto.setCategory(product.getCategory().getName());
        }
        return pDto;
    }




}
