package com.project_be.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
@Entity
@Table(name = "product_image")
public class ProductImage extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image")
    private String image;
    @ManyToOne
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductImage(Long id, String image, Product product) {
        this.id = id;
        this.image = image;
        this.product = product;
    }

    public ProductImage() {
    }

    public ProductImage(Long id, String img) {
        this.id = id;
        this.image = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
