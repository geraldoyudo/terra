package com.isslng.banking.processor.exception;

public class TransactionValidatorException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4482334256085111574L;
	public TransactionValidatorException() {
		super();
	}
	public TransactionValidatorException(String message){
		super(message);
	}
	public TransactionValidatorException(Throwable t){
		super(t);
	}
	public TransactionValidatorException(String message, Throwable t){
		super(message,t);
	}
	
}
