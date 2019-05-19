package com.gojek.test.parking_lot.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Car {

	private String registrationNumber;
	
	private String colour;

	public Car(String registrationNumber, String colour) {
		this.registrationNumber = registrationNumber;
		this.colour = colour;
	}
}
