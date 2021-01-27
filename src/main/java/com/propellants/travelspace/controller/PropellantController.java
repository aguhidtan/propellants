package com.propellants.travelspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.propellants.travelspace.dto.PropellantDTO;
import com.propellants.travelspace.exceptions.NotFoundException;
import com.propellants.travelspace.service.PropellantService;

/**
 * Controller for {@link PropellantDTO} endpoints
 * 
 * @author ahidalgo
 *
 */
@RestController
public class PropellantController {

    @Autowired
    private PropellantService service;

    /**
     * Get the list of {@link PropellantDTO}
     * 
     * @return {@link ResponseEntity} with list of {@link PropellantDTO}
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PropellantDTO>> findAll() {
	return ResponseEntity.ok(service.findAll());
    }

    /**
     * Get the detail of {@link PropellantDTO}
     * 
     * @param id - {@link PropellantDTO#getId()}
     * @return the {@link PropellantDTO} with the specified id
     * @throws NotFoundException if doesn`t exists a {@link PropellantDTO} with the
     *                           specified id
     */
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropellantDTO> getDetail(@PathVariable Long id) throws NotFoundException {
	return ResponseEntity.ok(service.findById(id));
    }
}
