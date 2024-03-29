package com.api.library.entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.api.library.utils.ParkingTollConstants;

@Component
@Qualifier("sedan")
public class SedanParkingSlot extends ParkingSlot {
	
	@Value("${sedan.parking.slots}")
	private int maxSedanSlots;
	
	@Override
	public Car createCarToPark(String plate, CarType type) {
		Car carToPark = new SedanCar();
		carToPark.setPlate(plate);
		return carToPark;
	}
	
	@Override
	public Integer getAvailableSlots() {
		return maxSedanSlots - parkSlotMap.size();
	}
	
	@Override
	public int getMaxNumberOfSlots() {
		return maxSedanSlots;
	}

	@Override
	public String getName() {
		return ParkingTollConstants.SEDAN_PARKING_SLOT_NAME;
	}

}
