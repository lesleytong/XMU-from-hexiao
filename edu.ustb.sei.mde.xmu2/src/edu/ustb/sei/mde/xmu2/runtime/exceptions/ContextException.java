package edu.ustb.sei.mde.xmu2.runtime.exceptions;

public class ContextException extends FatalException {

	public ContextException() {
		
	}

	public ContextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ContextException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ContextException(String message) {
		super(message);
		
	}

	public ContextException(Throwable cause) {
		super(cause);
		
	}

}
