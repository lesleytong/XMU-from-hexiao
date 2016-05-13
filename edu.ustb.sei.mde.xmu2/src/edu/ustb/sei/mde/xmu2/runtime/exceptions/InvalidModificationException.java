package edu.ustb.sei.mde.xmu2.runtime.exceptions;

public class InvalidModificationException extends FatalException {

	public InvalidModificationException() {
		
	}

	public InvalidModificationException(String message) {
		super(message);
		
	}

	public InvalidModificationException(Throwable cause) {
		super(cause);
		
	}

	public InvalidModificationException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidModificationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
