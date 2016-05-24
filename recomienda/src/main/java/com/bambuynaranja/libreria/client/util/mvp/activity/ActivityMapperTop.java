package com.bambuynaranja.libreria.client.util.mvp.activity;

import com.bambuynaranja.libreria.client.mvp.altaLibro.place.AltaLibroViewPlace;
import com.bambuynaranja.libreria.client.mvp.busquedaLibro.place.BusquedaLibroViewPlace;
import com.bambuynaranja.libreria.client.mvp.main.place.MainViewPlace;
import com.bambuynaranja.libreria.client.mvp.top.activity.TopActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class ActivityMapperTop implements ActivityMapper {

	private ActivityBase topActivity;

	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	public ActivityMapperTop() {
		super();
	}

	/**
	 * Map each Place to its corresponding Activity. This would be a great use
	 * for GIN.
	 */
	@Override
	public Activity getActivity( Place place ) {
		if ( topActivity == null ) {
			topActivity = new TopActivity();
		}

		topActivity.initActivity( place );
		

		if(place instanceof MainViewPlace){
			((TopActivity)topActivity).selectInicio();
		}else if(place instanceof AltaLibroViewPlace){
			((TopActivity)topActivity).selectAltaLibro();
		}else if(place instanceof BusquedaLibroViewPlace){
			((TopActivity)topActivity).selectBusquedaLibro();
		}else{
			//por defecto seleccionamos nueva valoracion
			((TopActivity)topActivity).selectInicio();
		}
		
		return topActivity;
	}
}

