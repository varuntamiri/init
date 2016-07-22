package com.technoglitz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) throws Exception {
		// if (args.length != 1) {
		// String usage = "example usage: ReflectionTest java.util.Calendar";
		// System.out.println(usage);
		// System.exit(0);
		// }

		Class<?> aClass = Class.forName("java.io.File");
		Field[] fields = aClass.getFields();
		System.out.println("Number of Fields = " + fields.length);

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println("[" + field.getName() + "] " + "with value [" + field.get(aClass) + "]");
		}

		Method[] methods = aClass.getMethods();
		System.out.println("\nNumber of Methods = " + methods.length);

		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println("[" + method.getName() + "] " + "returns [" + method.getReturnType() + "]");
		}
	}
}
