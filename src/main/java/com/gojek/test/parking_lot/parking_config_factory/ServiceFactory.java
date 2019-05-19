package com.gojek.test.parking_lot.parking_config_factory;

import com.gojek.test.parking_lot.Exception.NotFoundException;
import com.gojek.test.parking_lot.InputProcesser.ParkingLotConfigService;
import com.gojek.test.parking_lot.service.CreateParkingLot;
import com.gojek.test.parking_lot.service.LeaveService;
import com.gojek.test.parking_lot.service.ParkingService;
import com.gojek.test.parking_lot.service.RegNumForCarWithColours;
import com.gojek.test.parking_lot.service.SlotNumForCarWithColours;
import com.gojek.test.parking_lot.service.SlotNumForCarWithRegNum;
import com.gojek.test.parking_lot.service.LotStatusService;

/**
 * 
 * @author Khatribhu
 *
 */
public class ServiceFactory {

	private static final String CREATE_PARKING_LOT = "create_parking_lot";
	private static final String PARKING_SERVICE = "park";
	private static final String LEAVE_SERVICE = "leave";
	private static final String PARKING_LOT_STATUS = "status";
	private static final String REGISTRATION_NUMBERS_WITH_CARS_WITHOUT_COLOR = "registration_numbers_for_cars_with_colour";
	private static final String SLOT_NUMBERS_FOR_CARS_WITH_COLOR = "slot_numbers_for_cars_with_colour";
	private static final String SLOT_NUMBERS_FOR_REGISTRATION_NUMBER = "slot_number_for_registration_number";
	private static final String COMMAND_NOT_FOUND = "Command Not Found";

	public static ParkingLotConfigService getService(String inputCommand) throws NotFoundException {

		switch (inputCommand) {
		case CREATE_PARKING_LOT:
			return new CreateParkingLot();
		case PARKING_SERVICE:
			return new ParkingService();
		case LEAVE_SERVICE:
			return new LeaveService();
		case PARKING_LOT_STATUS:
			return new LotStatusService();
		case REGISTRATION_NUMBERS_WITH_CARS_WITHOUT_COLOR:
			return new RegNumForCarWithColours();
		case SLOT_NUMBERS_FOR_CARS_WITH_COLOR:
			return new SlotNumForCarWithColours();
		case SLOT_NUMBERS_FOR_REGISTRATION_NUMBER:
			return new SlotNumForCarWithRegNum();
		default:
			throw new NotFoundException(COMMAND_NOT_FOUND);
		}

	}
}