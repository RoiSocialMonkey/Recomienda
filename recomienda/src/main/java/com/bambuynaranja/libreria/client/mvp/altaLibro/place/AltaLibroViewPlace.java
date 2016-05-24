package com.bambuynaranja.libreria.client.mvp.altaLibro.place;

import com.bambuynaranja.libreria.client.Recomienda;
import com.bambuynaranja.libreria.client.mvp.main.place.MainViewPlace;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class AltaLibroViewPlace extends Place {
	private static final String NAME = "AltaLibro";

	public AltaLibroViewPlace() {
		super();
	}

	@Prefix(NAME)
	public static class Tokenizer implements PlaceTokenizer<AltaLibroViewPlace> {
		@Override
		public String getToken( AltaLibroViewPlace place ) {
			return "";
		}

		@Override
		public AltaLibroViewPlace getPlace(String token) {
			return new AltaLibroViewPlace();
		}
	}

	/*
	 * metodos STATIC.
	 * - Van al place
	 * - Devulven la URL se usan en los links
	 */
	public static void go() {
		Recomienda.getClientSingletonFactoryImpl().getPlaceController().goTo( new AltaLibroViewPlace() );
	}
	

	public static String getUrl() {
		return "#" + NAME + ":";
	}
}
