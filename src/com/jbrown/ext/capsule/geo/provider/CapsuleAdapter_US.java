package com.jbrown.ext.capsule.geo.provider;

import java.util.List;
import java.util.Map;

import com.jbrown.ext.capsule.geo.data.GeoIndiaCapsule;
import com.jbrown.ext.capsule.geo.data.GeoUsCapsule;
import com.jbrown.ext.capsule.impl.GeoCapsuleAdapter;

public class CapsuleAdapter_US extends GeoCapsuleAdapter{
	private GeoUsCapsule _capsule;
	
	public CapsuleAdapter_US() throws Exception {
		_capsule = new GeoUsCapsule();
	}

	@Override
	public List<Map<String, String>> getAllStates() {
		return _capsule.getAllIndianStates();
	}

	@Override
	public List<Map<String, String>> getPostalLocationsForCityName(
			String lookupStateCode, String lookupCityName) {
		return _capsule.getZipCodesForCity(lookupStateCode, lookupCityName);
	}

	@Override
	public List<Map<String, String>> getPostalLocationForZipCode(
			String lookupZipCode) {
		return _capsule.getZipCodeInfo(lookupZipCode);
	}

	@Override
	public List<Map<String, String>> getCitiesForStateCode(
			String lookupStateCode) {
		return _capsule.getCitiesForStateCode(lookupStateCode);
	}
}
