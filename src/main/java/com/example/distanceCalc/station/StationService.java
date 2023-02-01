package com.example.distanceCalc.station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
