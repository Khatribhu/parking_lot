package com.gojek.test.parking_lot.service;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.gojek.test.parking_lot.Exception.InvalidDataException;
import com.gojek.test.parking_lot.Exception.NotFoundException;
import com.gojek.test.parking_lot.models.Car;

public class Validator {
	
	private static final String PARKING_NOT_FOUND_CREATED_ONE = "Parking Lot Not Found. Create one first";
	private static final String INVALID_COMMAND_ARRAY = "Entered command array is not valid.";
	
	public static boolean validParkingLot(Map<Integer, Car> parkingLot) throws NotFoundException {
		if(parkingLot == null || parkingLot.isEmpty()) {
			throw new NotFoundException(PARKING_NOT_FOUND_CREATED_ONE);
		}
		return true;
	}
	
	public static boolean validCommandArray(String[] commandArray) throws InvalidDataException {
		if(commandArray != null && commandArray.length >= 1 && StringUtils.isNumeric(commandArray[1])) {
			return true;
		}
		throw new InvalidDataException(INVALID_COMMAND_ARRAY);
	}
	
	public static boolean validCommandArrayForCar(String[] commandArray) throws InvalidDataException {
		if(commandArray != null && commandArray.length >= 2 && StringUtils.isNumeric(commandArray[1])) {
			return true;
		}
		throw new InvalidDataException(INVALID_COMMAND_ARRAY);
	}
}
