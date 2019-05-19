package com.gojek.test.parking_lot.service;

import org.apache.commons.lang3.StringUtils;

import com.gojek.test.parking_lot.Exception.InvalidDataException;

public class Validator {

	private static final String INVALID_COMMAND_ARRAY = "Entered command array is not valid.";

	public static boolean validCommandArray(String[] commandArray) throws InvalidDataException {
		if (commandArray != null && commandArray.length >= 1 && StringUtils.isNumeric(commandArray[1])) {
			return true;
		}
		throw new InvalidDataException(INVALID_COMMAND_ARRAY);
	}

}
