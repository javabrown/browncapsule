package com.jbrown.ext.capsule;

import java.lang.reflect.Constructor;

import com.jbrown.ext.capsule.impl.BrownGeoCapsule;
import com.jbrown.ext.capsule.impl.BrownGeoCapsule.GeoCapsuleI;
import com.jbrown.ext.capsule.impl.BrownGeoCapsuleI;

public class BrownCapsule implements BrownCapsuleI{
	@Override
	public BrownGeoCapsuleI getGeoCapsule(String countryCode) throws Exception {
		Constructor c = CapsuleType.GEOGRAPHY.klass.getConstructor(String.class);
		return (BrownGeoCapsuleI) c.newInstance(countryCode);		
	}
	
	public static void main(String[] xx) throws Exception{
		BrownCapsuleI c = new BrownCapsule();
		System.out.println(c.getGeoCapsule("IN").getCapsuleData().getIsoCountries());
	}

}
