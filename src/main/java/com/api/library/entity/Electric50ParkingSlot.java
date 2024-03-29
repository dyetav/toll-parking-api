package com.api.library.entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.api.library.utils.ParkingTollConstants;

@Component
@Qualifier("elec50")
public class Electric50ParkingSlot extends ParkingSlot {
	
	@Value("${electric50.parking.slots}")
	private int maxElec50Slots;
	
	@Override
	public Car createCarToPark(String plate, CarType type) {
		Car carToPark = new Electric50kwCar();
		carToPark.setPlate(plate);
		return carToPark;
	}

	@Override
	public int getMaxNumberOfSlots() {
		return maxElec50Slots;
	}

	@Override
	public String getName() {
		return ParkingTollConstants.ELECTRIC_50_PARKING_SLOT_NAME;
	}

	@Override
	public Integer getAvailableSlots() {
		return maxElec50Slots - parkSlotMap.size();
	}

}
