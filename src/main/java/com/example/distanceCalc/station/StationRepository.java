package com.example.distanceCalc.station;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository //accesses data base, here using JPA
public interface StationRepository extends JpaRepository<Station, Integer> { //<Type we want to work with, id type>

	@Query("SELECT s FROM Station s WHERE s.abbr = ?1") //needed for distance calculation
	Optional<Station> findStationByAbbr(String abbr);
}
