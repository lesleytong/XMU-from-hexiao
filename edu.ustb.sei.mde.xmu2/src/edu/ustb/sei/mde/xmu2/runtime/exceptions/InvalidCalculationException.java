package edu.ustb.sei.mde.xmu2.runtime.exceptions;

public class InvalidCalculationException extends FatalException {

	public InvalidCalculationException() {
		
	}

	public InvalidCalculationException(String message) {
		super(message);
		
	}

	public InvalidCalculationException(Throwable cause) {
		super(cause);
		
	}

	public InvalidCalculationException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidCalculationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
