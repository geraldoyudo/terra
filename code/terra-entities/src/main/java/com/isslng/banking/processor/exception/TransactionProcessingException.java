package com.isslng.banking.processor.exception;

public class TransactionProcessingException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2181113773286091156L;
	public TransactionProcessingException() {
		super();
	}
	public TransactionProcessingException(String message){
		super(message);
	}
	public TransactionProcessingException(Throwable t){
		super(t);
	}
	public TransactionProcessingException(String message, Throwable t){
		super(message,t);
	}
	
}
