package com.gojek.test.parking_lot;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.Exception.NotFoundException;
import com.gojek.test.parking_lot.InputProcesser.InputArgumentConfigFactory;

/**
 * 
 * @author Khatribhu
 *
 */
public class ParkingLotMainApplication {

	public static void main(String[] args) throws NotFoundException, InternalServerException {
		if (args.length != 0) {
			InputArgumentConfigFactory.getInputParserConfig(args[0]);
		} else {
			InputArgumentConfigFactory.getInputParserConfig("");
		}
	}
}