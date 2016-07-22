package com.technoglitz.pattern.Factory;

public class TypeFactory {

	public static Type createType(String selection) {
		if (selection.equalsIgnoreCase("Specific")) {
			return new SpecficType();
		} else if (selection.equalsIgnoreCase("Generic")) {
			return new GenericType();
		}
		throw new IllegalArgumentException("Selection doesnot exist");
	}
}