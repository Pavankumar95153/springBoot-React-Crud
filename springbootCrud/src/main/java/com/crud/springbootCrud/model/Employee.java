package com.crud.springbootCrud.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Data
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name ="last_name",nullable = false)
    private String lastName;
    @Column(name="email",nullable = false)
    private String email;
}