package com.technoglitz.pattern.Factory;

public class Caller {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Type sType = TypeFactory.createType("Specific");
		System.out.println(sType.calcMethod());
		Type gtype = TypeFactory.createType("Generic");
		System.out.println(gtype.calcMethod());
	}
}