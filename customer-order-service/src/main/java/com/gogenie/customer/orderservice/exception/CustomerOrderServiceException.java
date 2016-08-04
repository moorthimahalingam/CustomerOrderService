package com.gogenie.customer.orderservice.exception;

public class CustomerOrderServiceException extends Exception {

	private String errorCode;
	private String errorDesc;
	
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

	public CustomerOrderServiceException(Exception e , String errorDetail) {
		super(errorDetail,e);
	}

	public CustomerOrderServiceException(Throwable throwable, String errorDtl) {
		super(errorDtl,throwable);
	}

	public CustomerOrderServiceException(Throwable throwable, String errorDtl, String errCode,
			String errDec) {
		super(errorDtl, throwable);
		this.errorCode = errCode;
		this.errorDesc = errDec;
	}
	
	public CustomerOrderServiceException(Exception exception, String errorDtl, String errCode,
			String errDec) {
		super(errorDtl, exception);
		this.errorCode = errCode;
		this.errorDesc = errDec;
	}
}
