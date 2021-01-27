package com.propellants.travelspace.exceptions;

/**
 * Class for handle the non exist elements
 * 
 * @author ahidalgo
 *
 */
public class NotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -4339749048915663120L;

    /**
     * Constructor that recive the error msg
     * 
     * @param msg - error msg
     */
    public NotFoundException(String msg) {
	super(msg);
    }

    /**
     * Constructor that recive the error msg and the exception
     * 
     * @param msg - error msg
     * @param e   - {@link Throwable} cause of the error
     */
    public NotFoundException(String msg, Throwable e) {
	super(msg, e);
    }
}
