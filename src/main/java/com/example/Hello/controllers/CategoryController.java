package com.example.Hello.controllers;


import com.example.Hello.models.Category;
import com.example.Hello.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Category")
public class CategoryController
{

    @Qualifier("DBSERVICE")
    @Autowired
    private IProductService myservice;

    @GetMapping("/{id}")
    public Category getProductById(@PathVariable("id") long Cid)
    {

        Category category = myservice.getCategoryById(Cid);
        if(category==null) {return null;  }
        return category;
    }

}
