package com.gojek.test.parking_lot.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.Exception.NotFoundException;
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
			if (!parking_lot.isEmpty() || parking_lot != null) {
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
					System.out.print("Not Found");
				} else {
					LOGGER.info(String.join(",", regList));
					System.out.println(String.join(",", regList));
				}
			} else {
				throw new NotFoundException("Parking Lot Not Found. Create one first");
			}

		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}
