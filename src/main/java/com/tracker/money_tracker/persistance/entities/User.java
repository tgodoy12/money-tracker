package com.tracker.money_tracker.persistance.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @UuidGenerator
    private String id;

    @NonNull // verificar que onda con el nonNull
    private String name;

    @NonNull
    @Column(unique = true, nullable = false)
    private String email;

    @NonNull
    private String password;

    @CreationTimestamp
    private LocalDate createdDate;



}
