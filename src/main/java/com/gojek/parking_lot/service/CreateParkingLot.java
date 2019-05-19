package com.gojek.parking_lot.service;

import java.util.ArrayList;
import java.util.List;

import com.gojek.parking_lot.Exception.InternalServerException;
import com.gojek.parking_lot.InputProcesser.ParkingLotConfigService;

/**
 * 
 * @author Khatribhu
 *
 */
public class CreateParkingLot extends ParkingLotConfigService {

	@Override
	public void executeCommand(String[] commandArray) throws InternalServerException {
		try {
			Integer parkingLotSpace = Integer.parseInt(commandArray[1]);
			List<Integer> placesInGarrage = new ArrayList<>();
			for (int i = 1; i <= parkingLotSpace; i++) {
				placesInGarrage.add(i);
			}
			places_left = placesInGarrage;
			size_alloted = parkingLotSpace;
			System.out.println("Created a parking lot with "+parkingLotSpace+" slots");

		} catch (Exception e) {
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}