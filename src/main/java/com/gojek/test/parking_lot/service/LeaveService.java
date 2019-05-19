package com.gojek.test.parking_lot.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.InputProcesser.ParkingLotConfigService;

/**
 * 
 * @author Khatribhu
 *
 */
public class LeaveService extends ParkingLotConfigService {

	private static Logger LOGGER = LoggerFactory.getLogger(LeaveService.class);

	@Override
	public void executeCommand(String[] commandArray) throws InternalServerException {
		try {
			Validator.validParkingLot(parking_lot);
			Validator.validCommandArray(commandArray);
			Integer parkingLotSpaceNumber = Integer.parseInt(commandArray[1]);
			parking_lot.remove(parkingLotSpaceNumber);
			LOGGER.info("Slot number " + parkingLotSpaceNumber + " is free");
			List<Integer> placesLeft = places_left;
			placesLeft.add(parkingLotSpaceNumber);
			Collections.sort(placesLeft);
			places_left = placesLeft;

		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}
