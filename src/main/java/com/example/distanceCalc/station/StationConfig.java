package com.example.distanceCalc.station;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StationConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StationRepository repository) {
		return args -> {
			Station xStation = new Station(1, "HH", "Hamburg", "VF", 7, 8);
			Station yStation = new Station(2, "B", "Berlin", "VF", 2, 10);
			Station zStation = new Station(3, "E", "Erfurt", "VF", 5, 5);
			Station kStation = new Station(4, "KAR", "Karlstadt", "RV", 2, 4);
			repository.saveAll(List.of(xStation,yStation,zStation, kStation));
		}; 
	}

}
