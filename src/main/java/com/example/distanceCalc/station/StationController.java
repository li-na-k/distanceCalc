package com.example.distanceCalc.station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(path = "{station1}/{station2}")
	public String getDistance(@PathVariable("station1") String station1,@PathVariable("station2") String station2){
		return stationService.getDistance(station1, station2);
	}

	
}
