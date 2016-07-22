package com.technoglitz.lambdaj;

/**
 * The Class Car.
 */
public class Car {

	private String brand;
	private String model;
	private int year;
	private double originalValue;

	/**
	 * @param brand
	 * @param model
	 * @param year
	 * @param originalValue
	 */
	public Car(String brand, String model, int year, double originalValue) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.originalValue = originalValue;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getOriginalValue() {
		return originalValue;
	}

	public void setOriginalValue(double originalValue) {
		this.originalValue = originalValue;
	}


}
