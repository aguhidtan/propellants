package com.propellants.travelspace.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.propellants.travelspace.dto.CarryCapacityDTO;
import com.propellants.travelspace.dto.PropellantDTO;
import com.propellants.travelspace.exceptions.NotFoundException;
import com.propellants.travelspace.service.PropellantService;

@ExtendWith(MockitoExtension.class)
public class PropellantControllerTest {

    @InjectMocks
    private PropellantController controller;
    @Mock
    private PropellantService service;

    @Test
    public void findAllTest() {
	final PropellantDTO p1 = new PropellantDTO();
	p1.setId(1L);
	p1.setName("LOX/RP-1");
	final PropellantDTO p2 = new PropellantDTO();
	p2.setId(2L);
	p2.setName("LOX/LH2");
	final List<PropellantDTO> expected = Arrays.asList(p1, p2);
	when(service.findAll()).thenReturn(expected);
	final ResponseEntity<List<PropellantDTO>> result = controller.findAll();
	assertEquals(HttpStatus.OK, result.getStatusCode());
	assertEquals(expected, result.getBody());
    }

    @Test
    public void getDetail() throws NotFoundException {
	final Long id = 1L;
	final PropellantDTO expected = new PropellantDTO(id, "LOX/RP-1", "kg", new CarryCapacityDTO(0.5, "kg"), 0.202);
	when(service.findById(id)).thenReturn(expected);
	final ResponseEntity<PropellantDTO> result = controller.getDetail(id);
	assertEquals(HttpStatus.OK, result.getStatusCode());
	assertEquals(expected, result.getBody());
    }

    @Test
    public void getDetailNotFoundErrorTest() {
	final Long id = 1L;
	assertThrows(NotFoundException.class, () -> {
	    try {
		when(service.findById(id)).thenThrow(new NotFoundException("Test Error"));
		controller.getDetail(id);
	    } catch (NotFoundException e) {
		verify(service).findById(id);
		throw e;
	    }
	});
    }
}
