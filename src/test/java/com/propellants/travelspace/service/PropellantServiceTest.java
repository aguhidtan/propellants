package com.propellants.travelspace.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.propellants.travelspace.dto.CarryCapacityDTO;
import com.propellants.travelspace.dto.PropellantDTO;
import com.propellants.travelspace.exceptions.NotFoundException;
import com.propellants.travelspace.mapper.ApiMapper;
import com.propellants.travelspace.model.Propellant;
import com.propellants.travelspace.repository.PropellantRepository;

@ExtendWith(MockitoExtension.class)
public class PropellantServiceTest {
    @InjectMocks
    private PropellantServiceImpl service;
    @Mock
    private PropellantRepository repository;
    @Spy
    private ApiMapper apiMapper;

    @Test
    public void findAllTest() {
	final PropellantDTO p1 = new PropellantDTO();
	p1.setId(1L);
	p1.setName("LOX/RP-1");
	final PropellantDTO p2 = new PropellantDTO();
	p2.setId(2L);
	p2.setName("LOX/LH2");
	final List<Object[]> propellants = new ArrayList<Object[]>();
	propellants.add(new Object[] { 1L, "LOX/RP-1" });
	propellants.add(new Object[] { 2L, "LOX/LH2" });
	when(repository.findMinimunInfo()).thenReturn(propellants);
	final List<PropellantDTO> result = service.findAll();
	assertEquals(2, result.size());
	assertEquals(p1, result.get(0));
	assertEquals(p2, result.get(1));
    }

    @Test
    public void findByIdTest() throws NotFoundException {
	final Long id = 1L;
	final Propellant p = new Propellant(id, "LOX/RP-1", "kg", 0.5, "kg", 0.202);
	final PropellantDTO expected = this.apiMapper.getPropellantMapper().map(p);
	expected.setCarryCapacity(new CarryCapacityDTO());
	expected.getCarryCapacity().setAmount(p.getCarryAmount());
	expected.getCarryCapacity().setUnit(p.getCarryUnit());
	when(repository.findById(id)).thenReturn(Optional.of(p));
	final PropellantDTO result = service.findById(id);
	assertEquals(expected, result);
    }

    @Test
    public void findByIdNotFoundErrorTest() {
	final Long id = 1L;
	when(repository.findById(id)).thenReturn(Optional.empty());
	assertThrows(NotFoundException.class, () -> service.findById(id));
	verify(repository).findById(id);
    }
}
