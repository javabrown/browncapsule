package com.jbrown.ext.capsule;

import java.io.Serializable;
import java.lang.reflect.Constructor;

import com.jbrown.ext.capsule.impl.BrownGeoCapsule;
import com.jbrown.ext.capsule.impl.BrownGeoCapsule.GeoCapsuleI;

public enum CapsuleType implements Serializable{
	GEOGRAPHY(1, "GEO", BrownGeoCapsule.class), 
	UTILITY(2, "UTIL", null);

	public final int id;
	public final String code;
	public final Class klass;
	
	private CapsuleType(int id, String code, Class klass) {
		this.id = id;
		this.code = code;
		this.klass = klass;
	}

	public static CapsuleType getInstance(int id) {
		for (CapsuleType c : CapsuleType.values()) {
			if (id == c.id)
				return c;
		}
		return null;
	}

	public boolean typeOf(CapsuleType capsule) {
		return getInstance(this.id).equals(capsule);
	}

}
