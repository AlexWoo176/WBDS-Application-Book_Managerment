package com.codegym.models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String price;
    private String image;
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")

    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Product() {
    }

    public Product(Long id, String name, String price, String image, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public Product(Long id, String name, String price, String image, String description, Author author) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
