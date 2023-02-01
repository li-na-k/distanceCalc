package com.example.distanceCalc.station;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.EnumKeySerializer;

//takes care of business logic
@Service
public class StationService {
	
	private final StationRepository stationRepository;

	@Autowired
	public StationService(StationRepository stationRepository) {
		this.stationRepository = stationRepository;
	}
	
	public List<Station> getStations(){
		return stationRepository.findAll(); //function from jpa interface
	}

	public String getDistance(String abbr1, String abbr2) {
		//Business Logic to check whether valid abbr code & FV station
		Station station1 = stationRepository.findStationByAbbr(abbr1.toUpperCase()).orElseThrow(
						() -> new IllegalStateException("There is no station with the DS100 abbreviation code '"+ abbr1 +"'."));
		Station station2 = stationRepository.findStationByAbbr(abbr2.toUpperCase()).orElseThrow(
				() -> new IllegalStateException("There is no station with the DS100 abbreviation code '"+ abbr2 +"'."));
		if(!(station1.getTrafficType().equals("FV") && station2.getTrafficType().equals("FV"))) {
			throw new IllegalStateException("Both stations must have a traffic type of 'FV'.");
		}
		return "distance between " + station1 + " and " + station2 + " is: xxxx";
	}
}
