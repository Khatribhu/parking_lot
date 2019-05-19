package com.gojek.test.parking_lot.InputProcesser;

import java.util.Scanner;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.Exception.NotFoundException;
import com.gojek.test.parking_lot.parking_config_factory.ServiceFactory;

/**
 * 
 * @author Khatribhu
 *
 */
public class InputParserImpl {

	private static final String REGAX = "\\s+";

	public InputParserImpl() throws NotFoundException, InternalServerException {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String command = scanner.nextLine();
			final ParkingLotConfigService deployer = ServiceFactory.getService(command);
			String[] commandArray = command.split(REGAX);
			deployer.executeCommand(commandArray);
		}
	}
}
