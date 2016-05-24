package com.bambuynaranja.libreria.client.util.mvp.view;

import java.util.HashMap;

import com.bambuynaranja.libreria.client.mvp.altaLibro.view.AltaLibroViewImpl;
import com.bambuynaranja.libreria.client.mvp.busquedaLibro.view.BusquedaLibroViewImpl;
import com.bambuynaranja.libreria.client.mvp.main.view.MainViewImpl;
import com.bambuynaranja.libreria.client.mvp.top.view.TopViewImpl;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.event.shared.EventBus;

public class ViewSingletonFactoryImpl {
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);

	private HashMap<NameViewEnum, IsWidget> views = new HashMap<NameViewEnum, IsWidget>();
	
	public EventBus getEventBus() {
		return eventBus;
	}
	
	public PlaceController getPlaceController() {
		return placeController;
	}

	public IsWidget getView(NameViewEnum name) {
		IsWidget view = null;
		view = views.get(name);
		if (view == null) {
			switch (name) {
				case TopView: {
					view = new TopViewImpl();
					break;
				}
				case MainView: {
					view = new MainViewImpl();
					break;
				}
				case AltaLibroView: {
					view = new AltaLibroViewImpl();
					break;
				}
				case BusquedaLibroView: {
					view = new BusquedaLibroViewImpl();
					break;
				}
			}
			views.put(name, view);
		}

		return view;
	}

}