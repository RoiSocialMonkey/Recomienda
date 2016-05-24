package com.bambuynaranja.libreria.client.mvp.busquedaLibro.activity;

import java.util.logging.Logger;

import com.bambuynaranja.libreria.client.Recomienda;
import com.bambuynaranja.libreria.client.mvp.busquedaLibro.place.BusquedaLibroViewPlace;
import com.bambuynaranja.libreria.client.mvp.busquedaLibro.view.BusquedaLibroView;
import com.bambuynaranja.libreria.client.util.mvp.activity.ActivityBase;
import com.bambuynaranja.libreria.client.util.mvp.view.NameViewEnum;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class BusquedaLibroViewActivity extends ActivityBase implements BusquedaLibroView.Delegate{

	private Logger log = Logger.getLogger( BusquedaLibroViewActivity.class.getName() );

	private BusquedaLibroViewPlace place;

	private BusquedaLibroView display;

	private AcceptsOneWidget containerWidget;

	public BusquedaLibroViewActivity() {
		display = (BusquedaLibroView) Recomienda.getClientSingletonFactoryImpl().getView( NameViewEnum.BusquedaLibroView );
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		this.containerWidget = containerWidget;
		containerWidget.setWidget(display.asWidget());
		display.setDelegate(this);
	}

	@Override
	public void initActivity(Place place) {
		this.place = (BusquedaLibroViewPlace) place;
	}

}
