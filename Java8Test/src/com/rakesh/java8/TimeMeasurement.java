package com.rakesh.java8;

import java.time.Duration;
import java.time.Instant;

public class TimeMeasurement {

	public static void main(String[] args) {
		Instant start = Instant.now();
		
		IPValidationRegex.checkForValidIPAdress();
		
		Instant end = Instant.now();
		System.out.println("Duraion taken for exe is: " + Duration.between(start, end).toMillis() + " in miliseconds.");
	}
}
