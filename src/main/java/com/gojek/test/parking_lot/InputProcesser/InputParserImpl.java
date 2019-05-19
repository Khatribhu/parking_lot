package com.gojek.test.parking_lot.InputProcesser;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.Exception.NotFoundException;
import com.gojek.test.parking_lot.parking_config_factory.ServiceFactory;

/**
 * 
 * @author Khatribhu
 *
 */
public class InputParserImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(InputParserImpl.class);
	private static final String REGAX = "\\s+";

	public InputParserImpl() throws NotFoundException, InternalServerException {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (true) {
			LOGGER.info("Input: ");
			String command = scanner.nextLine();
			final ParkingLotConfigService deployer = ServiceFactory.getService(command);
			LOGGER.info("OutPut: ");
			String[] commandArray = command.split(REGAX);
			deployer.executeCommand(commandArray);
		}
	}
}
