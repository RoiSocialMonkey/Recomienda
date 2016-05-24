package com.bambuynaranja.libreria.client.util.mvp.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.Place;

public abstract class ActivityBase extends AbstractActivity {
	/**
	 * Este es el primer metodo que se ejecuta y despues se lanza el metodo start.
	 * 
	 * @param place
	 */
	public abstract void initActivity( Place place );
	
	
}