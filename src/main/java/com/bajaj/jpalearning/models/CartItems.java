package com.bajaj.jpalearning.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "cart_items")
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @JsonBackReference
    private Customer customer;

    @ManyToOne
    private Product product;

    private Integer quantity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatesAt;

    public CartItems(){}

    public CartItems(Customer customer, Product product, Integer quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public CartItems(Long id, Customer customer, Product product, Integer quantity, LocalDateTime createdAt, LocalDateTime updatesAt) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatesAt = updatesAt;
    }

    @Override
    public String toString() {
        return "CartItems{" +
                "id=" + id +
                ", customer=" + customer +
                ", product=" + product +
                ", quantity='" + quantity + '\'' +
                ", createdAt=" + createdAt +
                ", updatesAt=" + updatesAt +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatesAt() {
        return updatesAt;
    }

    public void setUpdatesAt(LocalDateTime updatesAt) {
        this.updatesAt = updatesAt;
    }
}
