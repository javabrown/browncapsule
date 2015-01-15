package com.jbrown.ext.capsule;

import java.io.Serializable;
import java.lang.reflect.Constructor;

import com.jbrown.ext.capsule.airport.data.AirportCapsuleI;
import com.jbrown.ext.capsule.impl.BrownGeoCapsule;
import com.jbrown.ext.capsule.impl.BrownGeoCapsule.GeoCapsuleI;
import com.jbrown.ext.capsule.impl.BrownGeoCapsuleI;

public class BrownCapsule implements BrownCapsuleI, Serializable{
	private static final long serialVersionUID = 1L;

	@Override
	public BrownGeoCapsuleI getGeoCapsule(String countryCode) throws Exception {
		Constructor c = CapsuleType.GEOGRAPHY.klass.getConstructor(String.class);
		return (BrownGeoCapsuleI) c.newInstance(countryCode);		
	}
	
	@Override
	public AirportCapsuleI getAirportData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] xx) throws Exception{
		BrownCapsuleI c = new BrownCapsule();
		System.out.println(c.getGeoCapsule("IN").getCapsuleData().getIsoCountries());
	}

	

}
