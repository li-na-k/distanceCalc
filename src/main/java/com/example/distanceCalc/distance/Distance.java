package com.example.distanceCalc.distance;

import java.io.Console;

import com.example.distanceCalc.station.Station;

public class Distance {
	private String from;
	private String to;
	private Integer distance;
	private String unit;
	
	public Distance(String from, String to, Integer distance, String unit) {
		this.from = from;
		this.to = to;
		this.distance = distance;
		this.unit = unit;
	}
	
	public Distance(Station station1, Station station2) {
		this.from = station1.getName();
		this.to = station2.getName();
		this.unit = "km"; //TODO: implement as (optional) parameter
		double distanceMeters = distanceInMeters(station1.getLat(), station1.getLon(), station2.getLat(), station2.getLon());
		this.distance = (int) Math.round(distanceMeters/1000);
	}
	
	private static double distanceInMeters(double lat1, double lon1, double lat2, double lon2) {
		/* source: https://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude */
	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    distance = Math.pow(distance, 2);

	    return Math.sqrt(distance);
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Distance [from=" + from + ", to=" + to + ", distance=" + distance + ", unit=" + unit + "]";
	}	
	
}
