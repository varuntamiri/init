package com.msat.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class GeneralException extends SampleException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CONSTANT = "General Exception:";


	public GeneralException() {

	}

	public GeneralException(String strMsg) {
		super(CONSTANT + strMsg);
	}

	@Override
	public void setMessageKey(String key) {
		// TODO Auto-generated method stub
		super.setMessageKey(key);
	}

	@Override
	public void setRootCause(Throwable anException) {
		// TODO Auto-generated method stub
		super.setRootCause(anException);
	}

	/**
	 * This method takes exception as parameter and return the stack trace in
	 * string format
	 * 
	 * @param exception
	 * @return
	 */
	public static String getStackMessage(Throwable exception) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		pw.print(" [ ");
		pw.print(exception.getClass().getName());
		pw.print(" ] ");
		exception.printStackTrace(pw);
		return sw.toString();
	}
}
