package com.project_be.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "discount")
public class Discount extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "discountPercent")
    private BigDecimal discountPercent;
    @Column(name = "description")
    private String description;
    @ManyToOne
    private Product product;
    public Discount() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Discount(Long id, BigDecimal discountPercent, String description, Product product) {
        this.id = id;
        this.discountPercent = discountPercent;
        this.description = description;
        this.product = product;
    }

    public Discount(Long id, BigDecimal discountPercent, String description) {
        this.id = id;
        this.discountPercent = discountPercent;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
