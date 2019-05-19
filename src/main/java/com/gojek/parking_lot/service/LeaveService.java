package com.gojek.parking_lot.service;

import java.util.Collections;
import java.util.List;

import com.gojek.parking_lot.Exception.InternalServerException;
import com.gojek.parking_lot.InputProcesser.ParkingLotConfigService;

/**
 * 
 * @author Khatribhu
 *
 */
public class LeaveService extends ParkingLotConfigService {

	@Override
	public void executeCommand(String[] commandArray) throws InternalServerException {
		try {
			if (!parking_lot.isEmpty() || parking_lot != null) {
				Integer parkingLotSpaceNumber = Integer.parseInt(commandArray[1]);
				parking_lot.remove(parkingLotSpaceNumber);
				System.out.println("Slot number "+parkingLotSpaceNumber+" is free");
				List<Integer> placesLeft = places_left;
				placesLeft.add(parkingLotSpaceNumber);
				Collections.sort(placesLeft);
				places_left = placesLeft;
			}

		} catch (Exception e) {
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}
