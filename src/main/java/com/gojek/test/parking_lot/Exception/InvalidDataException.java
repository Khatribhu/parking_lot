package com.gojek.test.parking_lot.Exception;

/**
 * All invalid api request exceptions wrapped here
 * 
 * @author Khatribhu
 *
 */
public class InvalidDataException extends Exception {

	public InvalidDataException() {
		// Empty constructor
	}

	public InvalidDataException(String message) {
		super(message);
	}

	public InvalidDataException(Throwable cause) {
		super(cause);
	}

	public InvalidDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
