package com.jbrown.ext.capsule;

import com.jbrown.ext.capsule.airport.data.AirportCapsuleI;
import com.jbrown.ext.capsule.impl.BrownGeoCapsule;
import com.jbrown.ext.capsule.impl.BrownGeoCapsule.GeoCapsuleI;
import com.jbrown.ext.capsule.impl.BrownGeoCapsuleI;

public interface BrownCapsuleI {
	BrownGeoCapsuleI getGeoCapsule(String countryCode) throws Exception;
	AirportCapsuleI getAirportData() throws Exception;
}
