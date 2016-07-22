package com.technoglitz.pattern.Singleton;

/**
 * This Class is an example of double checked locking in Singleton pattern, here getInstance() method checks two times to see whether INSTANCE is null
 * or not and that’s why it’s called double checked locking pattern, remember that double checked locking is broker before Java 5 but with the
 * guaranteed of volatile variable in Java 5 memory model, it should work perfectly.
 */
public class DoubleCheckedLockingSingleton {

	private volatile DoubleCheckedLockingSingleton INSTANCE;

	private DoubleCheckedLockingSingleton() {
	}

	public DoubleCheckedLockingSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (DoubleCheckedLockingSingleton.class) {
				// double checking Singleton instance
				if (INSTANCE == null) {
					INSTANCE = new DoubleCheckedLockingSingleton();
				}
			}
		}
		return INSTANCE;
	}
	// You can call DoubleCheckedLockingSingleton.getInstance() to get access of this Singleton class.

	// TODO
	/* Override clone method to make it a perfect singleton */

}
