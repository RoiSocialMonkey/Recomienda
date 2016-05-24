package com.bambuynaranja.libreria.client.mvp.main.place;

import com.bambuynaranja.libreria.client.Recomienda;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class MainViewPlace extends Place {
	private static final String NAME = "inicio";

	public MainViewPlace() {
		super();
	}

	@Prefix(NAME)
	public static class Tokenizer implements PlaceTokenizer<MainViewPlace> {
		@Override
		public String getToken( MainViewPlace place ) {
			return "";
		}

		@Override
		public MainViewPlace getPlace(String token) {
			return new MainViewPlace();
		}
	}
	/*
	 * metodos STATIC.
	 * - Van al place
	 * - Devulven la URL se usan en los links
	 */
	public static void go() {
		Recomienda.getClientSingletonFactoryImpl().getPlaceController().goTo( new MainViewPlace() );
	}
	
	public static String getUrl() {
		return "#" + NAME + ":";
	}
}