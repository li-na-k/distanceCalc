package com.example.distanceCalc.station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//API Layer
@RestController
@RequestMapping(path = "api/v1/distance")
public class StationController {
	
	private final StationService stationService;
	
	@Autowired
	public StationController(StationService stationService){
		this.stationService = stationService;
	}
	
	@GetMapping
	public List<Station> getStations(){
		return stationService.getStations();
	}

	
}
