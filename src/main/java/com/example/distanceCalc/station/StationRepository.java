package com.example.distanceCalc.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //accesses data base, here using JPA
public interface StationRepository extends JpaRepository<Station, Integer> { //<Type we want to work with, id>

}
