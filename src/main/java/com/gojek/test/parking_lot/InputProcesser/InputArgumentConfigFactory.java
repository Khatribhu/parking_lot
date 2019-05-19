package com.gojek.test.parking_lot.InputProcesser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.Exception.NotFoundException;

/**
 * 
 * @author Khatribhu
 *
 */
public class InputArgumentConfigFactory {

	private static Logger LOGGER = LoggerFactory.getLogger(InputArgumentConfigFactory.class);
	
	public static void getInputParserConfig(String inputParser) throws NotFoundException, InternalServerException {
		if (inputParser.isEmpty()) {
			LOGGER.info("Processing console input");
			new InputParserImpl();
		} else {
			LOGGER.info("Processing file");
			new FileParser(inputParser);
		}
	}
}
