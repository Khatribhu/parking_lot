package com.gojek.test.parking_lot;

import org.junit.Assert;
import org.junit.Test;

import com.gojek.test.parking_lot.Exception.NotFoundException;
import com.gojek.test.parking_lot.parking_config_factory.ServiceFactory;
import com.gojek.test.parking_lot.service.CreateParkingLot;
import com.gojek.test.parking_lot.service.LeaveService;
import com.gojek.test.parking_lot.service.LotStatusService;
import com.gojek.test.parking_lot.service.ParkingService;
import com.gojek.test.parking_lot.service.RegNumForCarWithColours;

/**
 * 
 * @author Khatribhu
 */
public class ConfigFactoryTest {

	@Test
	public void testServiceFactory() throws NotFoundException {

		Assert.assertTrue((ServiceFactory.getService("create_parking_lot") instanceof CreateParkingLot));
		Assert.assertFalse((ServiceFactory.getService("create_parking_lot") instanceof ParkingService));

		Assert.assertTrue((ServiceFactory.getService("leave") instanceof LeaveService));
		Assert.assertFalse((ServiceFactory.getService("leave") instanceof CreateParkingLot));

		Assert.assertTrue((ServiceFactory.getService("status") instanceof LotStatusService));
		Assert.assertFalse((ServiceFactory.getService("status") instanceof CreateParkingLot));

		Assert.assertTrue((ServiceFactory.getService("park") instanceof ParkingService));
		Assert.assertFalse((ServiceFactory.getService("park") instanceof CreateParkingLot));
		Assert.assertFalse((ServiceFactory.getService("park") instanceof LeaveService));

		Assert.assertTrue((ServiceFactory
				.getService("registration_numbers_for_cars_with_colour") instanceof RegNumForCarWithColours));
		Assert.assertFalse(
				(ServiceFactory.getService("registration_numbers_for_cars_with_colour") instanceof CreateParkingLot));

	}
}
