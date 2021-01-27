package com.propellants.travelspace.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.propellants.travelspace.dto.CarryCapacityDTO;
import com.propellants.travelspace.dto.PropellantDTO;
import com.propellants.travelspace.exceptions.NotFoundException;
import com.propellants.travelspace.mapper.ApiMapper;
import com.propellants.travelspace.model.Propellant;
import com.propellants.travelspace.repository.PropellantRepository;

@Service
public class PropellantServiceImpl implements PropellantService {

    @Autowired
    private PropellantRepository repository;
    @Autowired
    private ApiMapper apiMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PropellantDTO> findAll() {
	return repository.findMinimunInfo().stream().map(result -> {
	    final PropellantDTO dto = new PropellantDTO();
	    dto.setId(Long.parseLong(result[0].toString()));
	    dto.setName(result[1].toString());
	    return dto;
	}).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PropellantDTO findById(Long id) throws NotFoundException {
	return repository.findById(id).map(this::toDto)
		.orElseThrow(() -> new NotFoundException(String.format("There is no Propellant with id %s", id)));
    }

    private PropellantDTO toDto(Propellant model) {
	final PropellantDTO dto = this.apiMapper.getPropellantMapper().map(model);
	dto.setCarryCapacity(new CarryCapacityDTO());
	dto.getCarryCapacity().setAmount(model.getCarryAmount());
	dto.getCarryCapacity().setUnit(model.getCarryUnit());

	return dto;
    }
}
