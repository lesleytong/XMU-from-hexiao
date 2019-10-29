package edu.ustb.sei.mde.xmu2.runtime.exceptions;

public class BuildException extends RuntimeException {

	public BuildException() {
		
	}

	public BuildException(String message) {
		super(message);
		
	}

	public BuildException(Throwable cause) {
		super(cause);
		
	}

	public BuildException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BuildException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
