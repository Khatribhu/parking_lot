package com.gojek.test.parking_lot.InputProcesser;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.Exception.NotFoundException;

/**
 * 
 * @author Khatribhu
 *
 */
public class InputArgumentConfigFactory {

	public static void getInputParserConfig(String inputParser) throws NotFoundException, InternalServerException {
		if (inputParser.isEmpty()) {
			new InputParserImpl();
		} else {
			new FileParser(inputParser);
		}
	}
}
