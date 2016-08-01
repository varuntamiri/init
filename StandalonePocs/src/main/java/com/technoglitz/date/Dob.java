package com.technoglitz.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Dob {

	public static void main(String[] args) {
		 LocalDate birthday = LocalDate.of(1992, 07, 19);
		    long yearsDelta = birthday.until(LocalDate.now(), ChronoUnit.YEARS);
		    System.out.println("yearsDelta = " + yearsDelta);
	}
}
