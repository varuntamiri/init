package com.technoglitz.lambdaj;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

import java.util.Comparator;
import java.util.List;

public class JavaEightLambdas {

	public static void main(String[] args) {
		
		Person buyer = new Person("Varun", "Tamiri", 31, true);
		Person seller = new Person("Sindhu", "Tamiri", 25, false);
		Person cuter = new Person("Lithu", "Tamiri", 1, false);
		Car car = new Car("BMW", "E5", 2012, 23.12d);
		
		Sale sale = new Sale(buyer, seller, car, 23.41d);
		Sale sale1 = new Sale(buyer, seller, car, 22.41d);

		List<Sale> sales = asList(sale,sale1);
		sales.forEach(out::println);// Print every Sale
		sales.forEach( (sale3) -> out.println(sale3) );//Print with a object reference

		Comparator<Person> sortByName = (Person s1, Person s2) -> (s1.compareTo(s2));//Sort comparator on main object
		Person[] players = {buyer,seller,cuter};
		sort(players , sortByName);
		
		Comparator<Sale> ageComparator = (Sale i1, Sale i2) -> ( i1.getCost().compareTo(i2.getCost()));//Sort comparator on object property
		Sale[] asList = {sale,sale1};
		sort(asList, ageComparator);
		
	}
}
