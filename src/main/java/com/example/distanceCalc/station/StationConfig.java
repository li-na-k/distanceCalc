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
			Station xStation = new Station(1, "F", "Frankfurt", "FV", 8.663789, 50.107145);
			Station yStation = new Station(2, "B", "Berlin", "FV", 13.369545, 52.525592);
			Station zStation = new Station(3, "E", "Erfurt", "FV", 5, 5);
			Station kStation = new Station(4, "KAR", "Karlstadt", "RV", 2, 4);
			repository.saveAll(List.of(xStation,yStation,zStation, kStation));
		}; 
	}

}
