package com.example.distanceCalc.station;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //for hibernate (map station to database)
@Table //for table in database
public class Station {
	@Id
	private Integer evaNr; 
	private String abbr;
//	private String infopt;
	private String name;
	private TrafficType trafficType; 
	private double lon;
	private double lat;
//	private String operatorName;
//	private Integer operatorNumber;
//	private String status;
	
	
	public Station(Integer evaNr, String abbr, String name, TrafficType trafficType, double lon, double lat) {
		this.evaNr = evaNr;
		this.abbr = abbr;
		this.name = name;
		this.trafficType = trafficType;
		this.lon = lon;
		this.lat = lat;
	}

	public Integer getEvaNr() {
		return evaNr;
	}

	public void setEvaNr(Integer evaNr) {
		this.evaNr = evaNr;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TrafficType getTrafficType() {
		return trafficType;
	}

	public void setTrafficType(TrafficType trafficType) {
		this.trafficType = trafficType;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(Integer lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(Integer lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "Station [evaNr=" + evaNr + ", abbr=" + abbr + ", name=" + name + ", trafficType=" + trafficType
				+ ", lon=" + lon + ", lat=" + lat + "]";
	}
	
	
}

