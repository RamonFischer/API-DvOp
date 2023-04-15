package com.api.apiDvops.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USERAPI")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 30, nullable = true)
    private String name;
    @Column(name = "email", length = 30, nullable = true)
    private String email;
    @Column(name = "password", columnDefinition = "TEXT", nullable = true)
    private String password;
    @Column(name = "telephone", length = 15, nullable = true)
    private String telephone;
}
