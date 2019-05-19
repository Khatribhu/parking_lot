package com.gojek.test.parking_lot.InputProcesser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.Exception.NotFoundException;
import com.gojek.test.parking_lot.parking_config_factory.ServiceFactory;

/**
 * 
 * @author Khatribhu
 *
 */
public class FileParser {

	private BufferedReader bufferedReader;

	public FileParser(String string) throws NotFoundException, InternalServerException {
		try {
			bufferedReader = new BufferedReader(new FileReader(string));
			String command;
			while ((command = bufferedReader.readLine()) != null) {
				final ParkingLotConfigService deployer = ServiceFactory.getService(command);
				String[] commandArray = command.split(" ");
				deployer.executeCommand(commandArray);
			}
		} catch (IOException e) {
			throw new InternalServerException(e.getMessage(), e);
		}
	}

}
