package com.msat.exception;

public class DataAccessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5521389784655656621L;

	private String messageKey = null;

	protected Throwable rootCause = null;

	public DataAccessException() {

	}

	public DataAccessException(String strMsg) {
		super(strMsg);
	}

	public DataAccessException(String strMsg, Throwable cause) {
		super(strMsg, cause);
	}

	/**
	 * @return the messageKey
	 */
	public String getMessageKey() {
		return messageKey;
	}

	/**
	 * @param messageKey the messageKey to set
	 */
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	/**
	 * @return the rootCause
	 */
	public Throwable getRootCause() {
		return rootCause;
	}

	/**
	 * @param rootCause the rootCause to set
	 */
	public void setRootCause(Throwable rootCause) {
		this.rootCause = rootCause;
	}

}
