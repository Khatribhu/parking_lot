package com.gojek.test.parking_lot.service;

import java.util.List;
import java.util.Map;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.InputProcesser.ParkingLotConfigService;
import com.gojek.test.parking_lot.models.Car;

/**
 * 
 * @author Khatribhu
 *
 */
public class ParkingService extends ParkingLotConfigService {

	private static final String PARKING_FULL = "Sorry, parking lot is full";

	@Override
	public void executeCommand(String[] commandArray) throws InternalServerException {
		try {
			if (!parking_lot.isEmpty() || parking_lot != null) {
				Car car = new Car(commandArray[1], commandArray[2]);
				List<Integer> totalPlacesLeft = places_left;
				if (totalPlacesLeft.isEmpty()) {
					System.out.println(PARKING_FULL);
				} else {
					// check if car already parked.
					if (carPresent(car)) {
						return;
					}
					Integer parkingSlot = totalPlacesLeft.get(0);
					if (totalPlacesLeft.size() <= size_alloted) {
						parking_lot.put(parkingSlot, car);
					}
					System.out.println("Allocated slot number: " + parkingSlot);
					totalPlacesLeft.remove(0);
				}
			} else {

			}

		} catch (Exception e) {
			throw new InternalServerException(e.getMessage(), e);
		}
	}

	private boolean carPresent(Car car) {
		if (parking_lot.values().contains(car)) {
			return true;
		}

		return false;
	}
}
