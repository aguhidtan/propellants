package com.propellants.travelspace.exceptions.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.propellants.travelspace.exceptions.NotFoundException;
import com.propellants.travelspace.exceptions.PropellantCustomExceptionHandler;

public class PropellantCustomExceptionHandlerTest {

    private PropellantCustomExceptionHandler handler = new PropellantCustomExceptionHandler();

    @Test
    @SuppressWarnings("unchecked")
    public void handleNotFoundExceptionTest() {
	final NotFoundException ex = new NotFoundException("Test Error");
	final ResponseEntity<Object> response = handler.handleNotFoundException(ex);
	assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	assertTrue(response.getBody() instanceof Map);
	final Map<String, Object> mapResult = (Map<String, Object>) response.getBody();
	assertEquals(ex.getMessage(), mapResult.get("message"));
    }
}
