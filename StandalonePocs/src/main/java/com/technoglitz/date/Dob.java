package com.technoglitz.date;

import static java.time.Instant.now;
import static java.time.LocalDate.of;
import static java.time.Period.between;
import static java.time.ZoneId.systemDefault;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

public class Dob {
	private static final Instant fixdIns = Instant.parse("2010-01-01T12:00:00Z");
	private static final Clock fixed = Clock.fixed(Dob.fixdIns, systemDefault());//Fixing the clocks to Jan 01, 2010

	public static void main(String[] args) {
		
		Dob dob = new Dob();
		int age = dob.getAge(1985, 10, 04);
		System.out.println("Age is  = " + age);
	}
	
	public int getAge(int year,int month, int day) {
		return between(of(year, month, day), LocalDateTime.ofInstant(now(Dob.fixed), systemDefault()).toLocalDate()).getYears();
	}
}
