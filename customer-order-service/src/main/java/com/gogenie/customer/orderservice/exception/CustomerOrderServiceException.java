package com.gogenie.customer.orderservice.exception;

public class CustomerOrderServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4074951255773438898L;

	public CustomerOrderServiceException() {
		super();
	}
	
	public CustomerOrderServiceException(String message) {
		super(message);
	}
	

	public CustomerOrderServiceException(Exception exception) {
		super(exception);
	}

	public CustomerOrderServiceException(Throwable throwable) {
		super(throwable);
	}

	public CustomerOrderServiceException(Exception e , String methodName) {
		super(e);
	}

	public CustomerOrderServiceException(Throwable throwable, String methodName) {
		super(throwable);
	}

}
