package com.msat.exception;

import java.util.ArrayList;
import java.util.List;

public class SampleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Throwable rootCause = null;

	private List<SampleException> exceptions = new ArrayList<SampleException>();

	private String messageKey = null;

	private Object[] messageArgs = null;

	public SampleException() {
		super();
	}

	public SampleException(String exceptionMsg) {
		super(exceptionMsg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor
	 * 
	 * @param rootCause
	 *            The Root Cause.
	 */

	public SampleException(Throwable rootCause) {
		this.rootCause = rootCause;
	}

	/**
	 * getException - get the list of chained exceptions
	 * 
	 * @param none
	 *            .
	 * @return List of exceptions
	 */

	public List<SampleException> getExceptions() {
		return exceptions;
	}

	/**
	 * addException - adds exceptions to the list of chained exceptions
	 * 
	 * @param SampleException
	 *            .
	 */

	public void addException(SampleException pe) {
		exceptions.add(pe);
	}

	/**
	 * setMessageKey - sets the message key as defined in the resource bundle
	 * 
	 * @param String
	 *            key.
	 * @return none
	 */

	public void setMessageKey(String key) {
		this.messageKey = key;
	}

	/**
	 * getMessageKey - gets the message key for the exception
	 * 
	 * @param none
	 *            .
	 * @return String the message key
	 */

	public String getMessageKey() {
		return messageKey;
	}

	/**
	 * setMessageArgs - sets the arguments that could be passed to message while
	 * display
	 * 
	 * @param Object
	 *            - arguments.
	 * @return none
	 */

	public void setMessageArgs(Object[] args) {
		this.messageArgs = args;
	}

	/**
	 * getMessageArgs - gets the arguments that could be passed to message while
	 * display
	 * 
	 * @param none
	 *            .
	 * @return Object - arguments
	 */

	public Object[] getMessageArgs() {
		return messageArgs;
	}

	/**
	 * setRootCause - sets the root cause of this exception
	 * 
	 * @param Throwable
	 *            - an exception.
	 * @return none
	 */

	public void setRootCause(Throwable anException) {
		this.rootCause = anException;
	}

	/**
	 * getRootCause - gets the root cause of this exception
	 * 
	 * @param none
	 *            .
	 * @return Throwable - rootcause
	 */

	public Throwable getRootCause() {
		return rootCause;
	}

}
