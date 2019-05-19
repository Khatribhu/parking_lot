package com.gojek.test.parking_lot.parking_config_factory;

import com.gojek.test.parking_lot.Exception.NotFoundException;
import com.gojek.test.parking_lot.InputProcesser.ParkingLotConfigService;
import com.gojek.test.parking_lot.service.CreateParkingLot;
import com.gojek.test.parking_lot.service.LeaveService;
import com.gojek.test.parking_lot.service.LotStatusService;
import com.gojek.test.parking_lot.service.ParkingService;
import com.gojek.test.parking_lot.service.RegNumForCarWithColours;
import com.gojek.test.parking_lot.service.SlotNumForCarWithColours;
import com.gojek.test.parking_lot.service.SlotNumForCarWithRegNum;

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

		if (inputCommand.contains(CREATE_PARKING_LOT)) {
			return new CreateParkingLot();
		} else if (inputCommand.contains(PARKING_SERVICE)) {
			return new ParkingService();
		} else if (inputCommand.contains(LEAVE_SERVICE)) {
			return new LeaveService();
		} else if (inputCommand.contains(PARKING_LOT_STATUS)) {
			return new LotStatusService();
		} else if (inputCommand.contains(REGISTRATION_NUMBERS_WITH_CARS_WITHOUT_COLOR)) {
			return new RegNumForCarWithColours();
		} else if (inputCommand.contains(SLOT_NUMBERS_FOR_CARS_WITH_COLOR)) {
			return new SlotNumForCarWithColours();
		} else if (inputCommand.contains(SLOT_NUMBERS_FOR_REGISTRATION_NUMBER)) {
			return new SlotNumForCarWithRegNum();
		} else {
			System.out.println("Command not found : " + inputCommand);
			throw new NotFoundException(COMMAND_NOT_FOUND);
		}

	}
}