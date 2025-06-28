package com.techjs.cloud.suppliers.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
@ToString
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private boolean active;

    private LocalDateTime createdAt;

    private int trustRating;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

}