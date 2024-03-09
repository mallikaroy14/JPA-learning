package com.bajaj.jpalearning.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // To auto increament
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    private int age;

    @Column(unique = true)
    private String emailId; // Write in camel case it will take email_Id in table

    private String username;

    @JsonIgnore
    private String password;

//    @ManyToMany
//    private List<Product> products;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<CartItems> cartItems;

    //cascade = CascadeType.ALL -> will work for all
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference
    @JsonIgnore
    private List<Address> addresses;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Customer() {

    }

    public Customer(String name, int age, String emailId, String password, String username) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Customer(Long id, String name, int age, String emailId, String password, List<CartItems> cartItems, List<Address> addresses, LocalDateTime createdAt, LocalDateTime updatedAt, String username) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.password = password;
        this.cartItems = cartItems;
        this.addresses = addresses;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.username = username;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }


    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", addresses=" + addresses +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
