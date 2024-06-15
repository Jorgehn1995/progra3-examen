package com.progra.examen.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="tasks")
@Setter
@Getter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo no puede estar vacio")
    @NotEmpty(message = "El campo no puede estar vacio")
    private String name;

    @NotBlank(message = "El campo no puede estar vacio")
    @NotEmpty(message = "El campo no puede estar vacio")
    private String description;


    private Boolean status = false;

    @Column(name="created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
}