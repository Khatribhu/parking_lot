package com.gojek.test.parking_lot.service;

import java.util.ArrayList;
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
public class CreateParkingLot extends ParkingLotConfigService {

	private static Logger LOGGER = LoggerFactory.getLogger(CreateParkingLot.class);

	@Override
	public void executeCommand(String[] commandArray) throws InternalServerException {
		try {
			Validator.validCommandArray(commandArray);
			Integer parkingLotSpace = Integer.parseInt(commandArray[1]);
			LOGGER.info("Processing command: " + commandArray[1]);
			List<Integer> placesInGarrage = new ArrayList<>();
			for (int i = 1; i <= parkingLotSpace; i++) {
				placesInGarrage.add(i);
			}
			places_left = placesInGarrage;
			size_alloted = parkingLotSpace;
			LOGGER.info("Created a parking lot with " + parkingLotSpace + " slots");

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}