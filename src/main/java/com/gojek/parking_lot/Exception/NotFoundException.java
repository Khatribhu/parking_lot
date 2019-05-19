package com.gojek.parking_lot.Exception;

/**
 * @author Khatribhu
 *
 */
public class NotFoundException extends Exception {

	/**
	 * Constructs a new exception with the detailed message
	 * @param message
	 */
	public NotFoundException(String message) {
		super(message);
	}
	
	/**
	 * Constructs a new exception with the cause of the exception
	 * @param cause
	 */
	public NotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new message with the detailed message and the cause of the exception
	 * @param message
	 * @param cause
	 */
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}