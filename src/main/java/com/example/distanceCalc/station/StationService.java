package com.example.distanceCalc.station;

import java.util.List;

import org.springframework.stereotype.Service;

//takes care of business logic
@Service
public class StationService {

	
	public List<Station> getStations(){
		return List.of(new Station(1, "HH", "Hamburg", "VF", 7, 8));
	}
}
