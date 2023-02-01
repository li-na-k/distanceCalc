package com.example.distanceCalc.csv;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.distanceCalc.helper.CSVHelper;
import com.example.distanceCalc.station.Station;
import com.example.distanceCalc.station.StationRepository;

@Service
public class CSVService {
	

	private final StationRepository stationRepository;
	
	@Autowired
	public CSVService(StationRepository stationRepository) {
		this.stationRepository = stationRepository;
	}
	

	  public void save(MultipartFile file) {
		    try {
		      List<Station> stations = CSVHelper.csvToStations(file.getInputStream()); //get Station List from CSV file
		      stationRepository.saveAll(stations); //save to DB
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }
		  }
	  
}
