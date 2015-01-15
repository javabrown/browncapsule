package com.jbrown.ext.capsule.airport.data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface AirportCapsuleI extends Serializable{
	List<Map<String, String>> getAirportsList();
	
	List<Map<String, String>> getAirportByIATACode(String lookupIataCode);
	
	List<Map<String, String>> getAirportByName(String lookupAirportName);
}
