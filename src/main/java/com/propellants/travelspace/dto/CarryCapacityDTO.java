package com.propellants.travelspace.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CarryCapacityDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4581709118790287111L;
    private Double amount;
    private String unit;
}
