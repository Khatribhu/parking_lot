package com.gojek.test.parking_lot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.InputProcesser.ParkingLotConfigService;
import com.gojek.test.parking_lot.models.Car;

/**
 * 
 * @author Khatribhu
 *
 */
public class ParkingService extends ParkingLotConfigService {

	private static Logger LOGGER = LoggerFactory.getLogger(ParkingService.class);
	private static final String PARKING_FULL = "Sorry, parking lot is full";

	@Override
	public void executeCommand(String[] commandArray) throws InternalServerException {
		try {
			if(!parking_lot.isEmpty() || parking_lot != null) {
				Car car = new Car(commandArray[1], commandArray[2]);
				List<Integer> totalPlacesLeft = places_left;
				if (totalPlacesLeft.isEmpty()) {
					LOGGER.info(PARKING_FULL);
					System.out.println("Sorry, parking lot is full");
				} else {
					Integer parkingSlot = totalPlacesLeft.get(0);
					if (totalPlacesLeft.size() <= size_alloted) {
						parking_lot.put(parkingSlot, car);
					}
					LOGGER.info("Allocated slot number:" + parkingSlot);
					System.out.println("Allocated slot number:"+ parkingSlot);
					totalPlacesLeft.remove(0);
				}
			} else {

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}
