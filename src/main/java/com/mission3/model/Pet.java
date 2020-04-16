package com.mission3.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Pet {
    @Id
    //automatic incrementation for id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull @NotEmpty
    private String name;

    private String description;

    @NotNull
    private boolean isExotic;

    @NotNull
    private double price;


}
