package com.gojek.test.parking_lot.InputProcesser;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.gojek.test.parking_lot.Exception.InternalServerException;
import com.gojek.test.parking_lot.models.Car;

/**
 * 
 * @author Khatribhu
 *
 */
public abstract class ParkingLotConfigService {

	public static List<Integer> places_left;
	public static int size_alloted;
	public static Map<Integer, Car> parking_lot = new ConcurrentHashMap<>();

	/**
	 * Processing command over the parking lot.
	 * @param commandArray
	 * @throws InternalServerException
	 */
	public abstract void executeCommand(String[] commandArray) throws InternalServerException;
}
