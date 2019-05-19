package com.gojek.parking_lot.service;


import com.gojek.parking_lot.Exception.InternalServerException;
import com.gojek.parking_lot.Exception.InvalidDataException;
import com.gojek.parking_lot.InputProcesser.ParkingLotConfigService;
import com.gojek.parking_lot.models.Car;

/**
 * 
 * @author Khatribhu
 *
 */
public class LotStatusService extends ParkingLotConfigService {

	private static final String PARKING_NOT_FOUND_CREATED_ONE = "Parking Lot Not Found. Create one first";

	@Override
	public void executeCommand(String[] commandArray) throws InternalServerException {
		try {
			if(!parking_lot.isEmpty() || parking_lot != null) {
				System.out.println("Slot No.    Registration No    Colour");
				Car car;
				for (int i = 1; i <= size_alloted; i++) {
					if (parking_lot.containsKey(i)) {
						car = parking_lot.get(i);
						System.out.println(i + "           " + car.getRegistrationNumber() + "      " + car.getColour());
					}
				}
			} else {
				throw new InvalidDataException(PARKING_NOT_FOUND_CREATED_ONE);
			}
			
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage(), e);
		}
	}
}