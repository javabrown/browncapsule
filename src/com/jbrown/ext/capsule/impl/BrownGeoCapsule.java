package com.jbrown.ext.capsule.impl;

import java.util.List;
import java.util.Map;

import com.jbrown.ext.capsule.BrownCapsuleI;
import com.jbrown.ext.capsule.CapsuleType;

public class BrownGeoCapsule implements BrownGeoCapsuleI {

	public BrownGeoCapsule(String countryCode) throws Exception {
		_countryCode = countryCode;
		_capsule = initializeCapsule();
	}
	
	@Override
	public GeoCapsuleI getCapsuleData() {
		return _capsule;
	}
	
	public interface GeoCapsuleI {
		public List<Map<String, String>> getIsoCountries();
		
		public List<Map<String, String>> getIsoCountryForCode(String lookupCode);
		
		public List<Map<String, String>> getAllStates();
		 
		public List<Map<String, String>> getCitiesForStateCode(
				String lookupStateCode);
		  
		List<Map<String, String>> getPostalLocationsForCityName(
				String lookupStateCode, String lookupCityName);
		
		public List<Map<String, String>> getPostalLocationForZipCode(
				String lookupZipCode);
	}
	
	private  GeoCapsuleI initializeCapsule() throws Exception {
		try {
			Class klass = Class
				 .forName("com.jbrown.ext.capsule.geo.provider.CapsuleAdapter_"
							+ _countryCode.toUpperCase());
			return (GeoCapsuleI) klass.newInstance();
		} catch (ClassNotFoundException e) {
			throw e;
		}
		catch (Exception e) {
				throw e;
		 }
	}
	
	private String _countryCode;
	private GeoCapsuleI _capsule;
}
