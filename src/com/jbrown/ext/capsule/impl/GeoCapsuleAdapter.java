package com.jbrown.ext.capsule.impl;

import java.util.List;
import java.util.Map;

import com.jbrown.ext.capsule.geo.data.GeoIsoCountryDataCapsule;

public abstract class GeoCapsuleAdapter implements BrownGeoCapsule.GeoCapsuleI{
	private GeoIsoCountryDataCapsule _isoCountryCapsule;
	
	public GeoCapsuleAdapter() throws Exception{
		_isoCountryCapsule = new GeoIsoCountryDataCapsule();
	}
	
	@Override
	public List<Map<String, String>> getIsoCountries() {
		return _isoCountryCapsule.getAllIsoCountries();
	}

	@Override
	public List<Map<String, String>> getIsoCountryForCode(String lookupCode) {
		return _isoCountryCapsule.getIsoCountryForCode(lookupCode);
	}
}
