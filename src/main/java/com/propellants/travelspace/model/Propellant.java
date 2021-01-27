package com.propellants.travelspace.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "propellants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Propellant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String baseUnit;
    private Double carryAmount;
    private String carryUnit;
    private Double price;
}
