package edu.ustb.sei.mde.xmu2.runtime.exceptions;

public abstract class FatalException extends RuntimeException {

	public FatalException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FatalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FatalException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FatalException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FatalException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
