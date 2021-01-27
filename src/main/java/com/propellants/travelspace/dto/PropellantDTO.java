package com.propellants.travelspace.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
public class PropellantDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1084185695293814347L;
    private Long id;
    private String name;
    private String baseUnit;
    private CarryCapacityDTO carryCapacity;
    private Double price;
}
