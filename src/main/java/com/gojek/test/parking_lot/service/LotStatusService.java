package com.gojek.test.parking_lot.service;

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
public class LotStatusService extends ParkingLotConfigService {

	private static Logger LOGGER = LoggerFactory.getLogger(LeaveService.class);

	@Override
	public void executeCommand(String[] commandArray) throws InternalServerException {
		try {

			Validator.validParkingLot(parking_lot);
			LOGGER.info("Slot No.\tRegistration No.\tColor");
			Car car;
			for (int i = 1; i <= parking_lot.size(); i++) {
				if (parking_lot.containsKey(i)) {
					car = parking_lot.get(i);
					LOGGER.info(i + "\t" + car.getRegistrationNumber() + "\t" + car.getColour());
				}
			}
			
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}