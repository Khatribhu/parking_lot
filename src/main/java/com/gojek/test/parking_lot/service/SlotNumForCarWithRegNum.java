package com.gojek.test.parking_lot.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.Exception.NotFoundException;
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
			if (!parking_lot.isEmpty() || parking_lot != null) {
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
					System.out.print("Not found");
				} else {
					LOGGER.info(String.join(",", slotNum));
					System.out.println(String.join(",", slotNum));
				}
			} else {
				LOGGER.error("Parking Lot Not Found. Create one first");
				throw new NotFoundException("Parking Lot Not Found. Create one first");
			}

		} catch (Exception e) {
			LOGGER.info(e.getMessage(), e);
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}
