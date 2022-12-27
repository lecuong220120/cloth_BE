package com.project_be.model;

import javax.persistence.*;

@Entity
@Table(name = "product_size")
public class ProductSize extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    private ProductSizeEnum size;
    @ManyToOne
    private Product product;

    public ProductSize(Long id, ProductSizeEnum size, Product product) {
        this.id = id;
        this.size = size;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductSize() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductSizeEnum getSize() {
        return size;
    }

    public void setSize(ProductSizeEnum size) {
        this.size = size;
    }
}
