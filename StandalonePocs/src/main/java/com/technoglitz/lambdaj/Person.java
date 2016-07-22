package com.technoglitz.lambdaj;

/**
 * The Class Person.
 */
public class Person {

	private String firstName;
	private String lastName;
	private int age;
	private boolean male;

	/**
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param male
	 */
	public Person(String firstName, String lastName, int age, boolean male) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.male = male;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

}
