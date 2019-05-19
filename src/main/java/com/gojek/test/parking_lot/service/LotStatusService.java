package com.gojek.test.parking_lot.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.Exception.InvalidDataException;
import com.gojek.test.parking_lot.InputProcesser.ParkingLotConfigService;
import com.gojek.test.parking_lot.models.Car;

/**
 * 
 * @author Khatribhu
 *
 */
public class LotStatusService extends ParkingLotConfigService {

	private static Logger LOGGER = LoggerFactory.getLogger(LeaveService.class);
	private static final String PARKING_NOT_FOUND_CREATED_ONE = "Parking Lot Not Found. Create one first";

	@Override
	public void executeCommand(String[] commandArray) throws InternalServerException {
		try {
			if(!parking_lot.isEmpty() || parking_lot != null) {
				LOGGER.info("Slot No.\tRegistration No.\tColor");
				System.out.println("Slot No.\tRegistration No.\tColor");
				Car car;
				for (int i = 1; i <= parking_lot.size(); i++) {
					if (parking_lot.containsKey(i)) {
						car = parking_lot.get(i);
						LOGGER.info(i + "\t" + car.getRegistrationNumber() + "\t" + car.getColour());
						System.out.println(i + "\t" + car.getRegistrationNumber() + "\t" + car.getColour());
					}
				}
			} else {
				throw new InvalidDataException(PARKING_NOT_FOUND_CREATED_ONE);
			}
			
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}