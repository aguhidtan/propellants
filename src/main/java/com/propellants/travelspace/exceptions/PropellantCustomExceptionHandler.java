package com.propellants.travelspace.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Handler for Rest excpetions
 * 
 * @author ahidalgo
 *
 */
@ControllerAdvice
public class PropellantCustomExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Creates a Rest response from a {@link NotFoundException}
     * 
     * @param ex - {@link NotFoundException} with the error
     * @return {@link ResponseEntity} with the error message
     */
    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
	final Map<String, Object> result = new HashMap<String, Object>();
	result.put("message", ex.getMessage());

	return ResponseEntity.badRequest().body(result);
    }
}
