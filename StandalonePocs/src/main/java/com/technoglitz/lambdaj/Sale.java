package com.technoglitz.lambdaj;

/**
 * The Class Sale.
 */
public class Sale {

	private Person buyer;
	private Person seller;
	private Car car;
	private Double cost;

	/**
	 * @param buyer
	 * @param seller
	 * @param car
	 * @param cost
	 */
	public Sale(Person buyer, Person seller, Car car, Double cost) {
		this.buyer = buyer;
		this.seller = seller;
		this.car = car;
		this.cost = cost;
	}

	public Person getBuyer() {
		return buyer;
	}

	public void setBuyer(Person buyer) {
		this.buyer = buyer;
	}

	public Person getSeller() {
		return seller;
	}

	public void setSeller(Person seller) {
		this.seller = seller;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
}
