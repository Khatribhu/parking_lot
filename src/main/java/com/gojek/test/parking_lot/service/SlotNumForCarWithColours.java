package com.gojek.test.parking_lot.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.Exception.NotFoundException;
import com.gojek.test.parking_lot.InputProcesser.ParkingLotConfigService;
import com.gojek.test.parking_lot.models.Car;

/**
 * 
 * @author Khatribhu
 *
 */
public class SlotNumForCarWithColours extends ParkingLotConfigService {

	@Override
	public void executeCommand(String[] commandArray) throws InternalServerException {
		try {
			if (!parking_lot.isEmpty() || parking_lot != null) {
				String colour = commandArray[1];
				boolean flag = true;
				Collection<Car> allCars = parking_lot.values();
				List<String> slotNum = new ArrayList<>();
				for (Car car : allCars) {
					if (car.getColour().equals(colour)) {
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
					System.out.println("Not found");
				} else {
					System.out.println(String.join(", ", slotNum));
				}
			} else {
				throw new NotFoundException("Parking Lot Not Found. Create one first");
			}

		} catch (Exception e) {
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}