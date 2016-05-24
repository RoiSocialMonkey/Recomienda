package com.bambuynaranja.libreria.client.util.mvp.place;

import com.bambuynaranja.libreria.client.mvp.altaLibro.place.AltaLibroViewPlace;
import com.bambuynaranja.libreria.client.mvp.busquedaLibro.place.BusquedaLibroViewPlace;
import com.bambuynaranja.libreria.client.mvp.main.place.MainViewPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */
@WithTokenizers( { 
	MainViewPlace.Tokenizer.class,
	AltaLibroViewPlace.Tokenizer.class,
	BusquedaLibroViewPlace.Tokenizer.class
	} )
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
