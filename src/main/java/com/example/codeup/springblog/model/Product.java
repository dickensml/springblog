package com.example.codeup.springblog.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")

    private long id;

    @Column(length = 100, nullable = false)
    private String name;

    private int priceInCents;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    public Product(String name, int priceInCents) {
        this.name = name;
        this.priceInCents = priceInCents;
    }
}
