package com.gojek.test.parking_lot.service;

import java.util.ArrayList;
import java.util.Collection;
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
public class RegNumForCarWithColours extends ParkingLotConfigService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegNumForCarWithColours.class);

	@Override
	public void executeCommand(String[] commandArray) throws InternalServerException {
		try {
			Validator.validParkingLot(parking_lot);
			String colour = commandArray[1];
			boolean flag = false;
			Collection<Car> allCars = parking_lot.values();
			List<String> regList = new ArrayList<>();
			for (Car car : allCars) {
				if (car.getColour().equals(colour)) {
					flag = true;
					regList.add(car.getRegistrationNumber());
				}
			}
			if (flag == false) {
				LOGGER.info("Not Found");
			} else {
				LOGGER.info(String.join(",", regList));
			}

		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}
