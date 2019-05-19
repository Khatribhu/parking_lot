package com.gojek.test.parking_lot.Exception;

/**
 * @author Khatribhu
 *
 */
public class InternalServerException extends Exception {

	/**
	 * Constructs a new exception with the detailed message
	 * @param message
	 */
	public InternalServerException(String message) {
		super(message);
	}
	
	/**
	 * Constructs a new exception with the cause of the exception
	 * @param cause
	 */
	public InternalServerException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new message with the detailed message and the cause of the exception
	 * @param message
	 * @param cause
	 */
	public InternalServerException(String message, Throwable cause) {
		super(message, cause);
	}
}