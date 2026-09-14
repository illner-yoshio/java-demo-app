package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password_hash")
    private String passwordHash;

    // getter / setter
    public String getUserId() {
        return userId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}