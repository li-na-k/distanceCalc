package com.example.distanceCalc.station;

public enum TrafficType {
	RV, FV, nur_DPN, RVnur_DPN;

	
    public static TrafficType fromString(final String name) { //to get a more understandable error message
        try {
        	return TrafficType.valueOf(name);
        }
        catch(IllegalArgumentException e) {
        	throw new IllegalArgumentException("Invalid value for traffic type found: " + name + " is not valid.");
        }
    }
}
