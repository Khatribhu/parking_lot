package com.gojek.test.parking_lot.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.InputProcesser.InputParserImpl;
import com.gojek.test.parking_lot.InputProcesser.ParkingLotConfigService;
import com.gojek.test.parking_lot.models.Car;

/**
 * 
 * @author Khatribhu
 *
 */
public class SlotNumForCarWithRegNum extends ParkingLotConfigService {

	private static final Logger LOGGER = LoggerFactory.getLogger(InputParserImpl.class);

	@Override
	public void executeCommand(String[] commandArray) throws InternalServerException {
		try {
			Validator.validParkingLot(parking_lot);
			boolean flag = false;
			String registrationNumber = commandArray[1];
			Collection<Car> allCars = parking_lot.values();
			List<String> slotNum = new ArrayList<>();
			for (Car car : allCars) {
				if (car.getRegistrationNumber().equals(registrationNumber)) {
					for (Entry<Integer, Car> entry : parking_lot.entrySet()) {
						if (entry.getValue().equals(car)) {
							flag = true;
							String key = entry.getKey().toString();
							slotNum.add(key);
						}
					}
				}
			}
			if (flag == false) {
				LOGGER.info("Not found");
			} else {
				LOGGER.info(String.join(",", slotNum));
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}
