package com.propellants.travelspace.mapper;

import org.springframework.stereotype.Component;

import com.propellants.travelspace.dto.PropellantDTO;
import com.propellants.travelspace.model.Propellant;

import lombok.Getter;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * Mappers for parse objects between Entity and DTO
 * 
 * @author ahidalgo
 *
 */
@Component
@Getter
public class ApiMapper extends ConfigurableMapper {

    private BoundMapperFacade<Propellant, PropellantDTO> propellantMapper;

    @Override
    protected void configure(MapperFactory factory) {
	factory.classMap(Propellant.class, PropellantDTO.class).mapNulls(true).mapNullsInReverse(true).byDefault()
		.register();
	this.propellantMapper = super.dedicatedMapperFor(Propellant.class, PropellantDTO.class);
    }
}
