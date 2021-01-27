package com.propellants.travelspace.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.propellants.travelspace.dto.PropellantDTO;
import com.propellants.travelspace.model.Propellant;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

@ExtendWith(MockitoExtension.class)
public class ApiMapperTest {
    @Mock
    private MapperFactory factory;
    @Mock
    private ClassMapBuilder<Propellant, PropellantDTO> propellantBuilder;
    private ApiMapper apiMapper = new ApiMapper();

    @Test
    public void configureTest() {
	when(factory.classMap(Propellant.class, PropellantDTO.class)).thenReturn(propellantBuilder);
	when(propellantBuilder.mapNulls(true)).thenReturn(propellantBuilder);
	when(propellantBuilder.mapNullsInReverse(true)).thenReturn(propellantBuilder);
	when(propellantBuilder.byDefault()).thenReturn(propellantBuilder);
	apiMapper.configure(factory);
	assertNotNull(apiMapper.getPropellantMapper());
	verify(factory).classMap(Propellant.class, PropellantDTO.class);
	verify(propellantBuilder).mapNulls(true);
	verify(propellantBuilder).mapNullsInReverse(true);
	verify(propellantBuilder).byDefault();
    }
}
