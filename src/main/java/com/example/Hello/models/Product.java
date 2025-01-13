package com.example.Hello.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Product extends BaseModel
{
    private String title;
    private String description;
    private String ImageUrl;
    private Double amount;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private boolean IsPrimespecific;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isPrimespecific() {
        return IsPrimespecific;
    }

    public void setPrimespecific(boolean primespecific) {
        IsPrimespecific = primespecific;
    }
}
