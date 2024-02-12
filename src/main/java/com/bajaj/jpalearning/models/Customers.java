package com.bajaj.jpalearning.models;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="name")
    private String name;

    private int age;

    private String emailId;

}
