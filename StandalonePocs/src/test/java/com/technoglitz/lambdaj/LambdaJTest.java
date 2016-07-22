package com.technoglitz.lambdaj;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.hamcrest.Matchers;
import org.junit.Test;

import ch.lambdaj.Lambda;

public class LambdaJTest {

	// preparing data for Persons
	Person buyer = new Person("Mc", "Bruce", 40, true);
	Person seller = new Person("Marc", "Ben", 30, true);

	// preparing data for Cars
	Car merc = new Car("Benz", "Class C", 2006, 40000d);
	Car bmw = new Car("BMW", "E38", 2010, 50000d);
	Car ferrari = new Car("Ferrari", "Class C", 2006, 80000d);

	List<Car> cars = Arrays.asList(merc, bmw, ferrari);

	// preparing data for Sales
	Sale sale1 = new Sale(buyer, seller, ferrari, 90000d);
	Sale sale2 = new Sale(buyer, seller, bmw, 90000d);
	Sale sale3 = new Sale(buyer, seller, merc, 90000d);
	Sale sale4 = new Sale(buyer, seller, ferrari, 90000d);
	Sale sale5 = new Sale(buyer, seller, ferrari, 90000d);

	List<Sale> sales = Arrays.asList(sale1, sale2, sale3, sale4, sale5);

	@Test
	public void testJoinFrom() {

		String brands = Lambda.joinFrom(cars).getBrand();

		Assert.assertEquals("Benz, BMW, Ferrari", brands);

	}
	
	@Test
	public void testSelect() throws Exception {
		List<Sale> salesOfFerrari = Lambda.select(sales, Lambda.having(Lambda.on(Sale.class).getCar().getBrand(), Matchers.equalTo("Ferrari")));

		Assert.assertEquals(3, salesOfFerrari.size());

	}

}
