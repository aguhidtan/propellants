package com.propellants.travelspace.service;

import java.util.List;

import com.propellants.travelspace.dto.PropellantDTO;
import com.propellants.travelspace.exceptions.NotFoundException;

/**
 * Service for {@link PropellantDTO} operations
 * 
 * @author ahidalgo
 *
 */
public interface PropellantService {

    /**
     * Obtain a list with the {@link PropellantDTO#getId()} and
     * {@link PropellantDTO#getName()}
     * 
     * @return list of {@link PropellantDTO}
     */
    List<PropellantDTO> findAll();

    /**
     * Obtain the {@link PropellantDTO} with the specified id
     * 
     * @param id - {@link PropellantDTO#getId()}
     * 
     * @return {@link PropellantDTO}
     */
    PropellantDTO findById(Long id) throws NotFoundException;
}
