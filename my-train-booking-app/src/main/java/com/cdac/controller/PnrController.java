package com.cdac.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Passenger;
import com.cdac.entity.Pnr;
import com.cdac.entity.Passenger.Gender;
import com.cdac.entity.Passenger.Status;

@RestController
public class PnrController {

	@GetMapping("/pnr/{pnrNo}")
	public Pnr check(@PathVariable int pnrNo) {
		//for the time  being we will hardcode the details and send it
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrNo);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2023, 7, 20));
		
		List<Passenger> list = new ArrayList<>();

		Passenger passenger1 = new Passenger();
		passenger1.setName("Ram");
		passenger1.setGender(Gender.MALE);
		passenger1.setStatus(Status.CONFIRMED);
		Passenger passenger2 = new Passenger();
		passenger2.setName("Shyam");
		passenger2.setGender(Gender.MALE);
		passenger2.setStatus(Status.RAC);
		
		list.add(passenger1);
		list.add(passenger2);
		pnr.setPassengers(list);
		
		return pnr;
		
	}
}
