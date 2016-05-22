/**
 * 
 */
package com.naren.exceptiion;

/**
 * @author nstanwar
 *
 */
public class NoSuchProductException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8017028698959994144L;
	private int productId;
	/**
	 * 
	 */
	public NoSuchProductException() {
		 
	}

	/**
	 * @param message
	 */
	public NoSuchProductException(String message) {
		super(message);
		 
	}

	/**
	 * @param cause
	 */
	public NoSuchProductException(Throwable cause) {
		super(cause);
		 
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoSuchProductException(String message, Throwable cause) {
		super(message, cause);
		 
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public NoSuchProductException(String message,int productId, Throwable cause) {
		super(message, cause);
		this.productId = productId;
		 
	}
	/**
	 * @param message
	 * @param cause
	 */
	public NoSuchProductException(String message,int productId) {
		super(message);
		this.productId = productId;
		 
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NoSuchProductException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		 
	}

	public int getProductId(){
		return productId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.getMessage()+"for product id :" + productId;
	}
	
}
