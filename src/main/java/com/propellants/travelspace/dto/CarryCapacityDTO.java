package com.propellants.travelspace.dto;

import java.io.Serializable;

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
public class CarryCapacityDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4581709118790287111L;
    private Double amount;
    private String unit;
}
