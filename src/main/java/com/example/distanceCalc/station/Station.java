package com.example.distanceCalc.station;

public class Station {
	private Integer evaNr;
	private String abbr;
//	private String infopt;
	private String name;
	private String trafficType; //TODO implement as enum
	private Integer lon;
	private Integer lat;
//	private String operatorName;
//	private Integer operatorNumber;
//	private String status;
	
	public Station(Integer evaNr, String abbr, String name, String trafficType, Integer lon, Integer lat) {
		super();
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

	public String getTrafficType() {
		return trafficType;
	}

	public void setTrafficType(String trafficType) {
		this.trafficType = trafficType;
	}

	public Integer getLon() {
		return lon;
	}

	public void setLon(Integer lon) {
		this.lon = lon;
	}

	public Integer getLat() {
		return lat;
	}

	public void setLat(Integer lat) {
		this.lat = lat;
	}
}

