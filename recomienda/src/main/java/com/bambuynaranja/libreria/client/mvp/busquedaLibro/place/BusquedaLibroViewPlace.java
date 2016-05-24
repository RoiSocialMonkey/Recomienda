package com.bambuynaranja.libreria.client.mvp.busquedaLibro.place;

import com.bambuynaranja.libreria.client.Recomienda;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class BusquedaLibroViewPlace extends Place {
	private static final String NAME = "BusquedaLibro";

	public BusquedaLibroViewPlace() {
		super();
	}

	@Prefix(NAME)
	public static class Tokenizer implements PlaceTokenizer<BusquedaLibroViewPlace> {
		@Override
		public String getToken( BusquedaLibroViewPlace place ) {
			return "";
		}

		@Override
		public BusquedaLibroViewPlace getPlace(String token) {
			return new BusquedaLibroViewPlace();
		}
	}

	/*
	 * metodos STATIC.
	 * - Van al place
	 * - Devulven la URL se usan en los links
	 */
	public static void go() {
		Recomienda.getClientSingletonFactoryImpl().getPlaceController().goTo( new BusquedaLibroViewPlace() );
	}
	

	public static String getUrl() {
		return "#" + NAME + ":";
	}
}
