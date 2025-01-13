package com.example.Hello.dtos;

import com.example.Hello.models.BaseModel;
import com.example.Hello.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Categorydto
{       private long id;
        private String name;
        private String description;
        private List<Product> products;

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public List<Product> getProducts() {
                return products;
        }

        public void setProducts(List<Product> products) {
                this.products = products;
        }
}

