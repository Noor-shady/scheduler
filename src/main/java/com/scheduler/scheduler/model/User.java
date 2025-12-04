package com.scheduler.scheduler.model;

import jakarta.persistence.*;

@Entity
@Table(name = "app_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // No two users can have the same username
    @Column(unique = true)
    private String username;

    private String password;
    private String email;
    // Examples: "ADMIN", "CUSTOMER"
    private String role;

    public User() {
    }

    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

