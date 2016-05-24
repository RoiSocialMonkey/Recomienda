package com.bambuynaranja.libreria.client.mvp.altaLibro.activity;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.bambuynaranja.libreria.client.Recomienda;
import com.bambuynaranja.libreria.client.model.Libro;
import com.bambuynaranja.libreria.client.mvp.altaLibro.place.AltaLibroViewPlace;
import com.bambuynaranja.libreria.client.mvp.altaLibro.view.AltaLibroView;
import com.bambuynaranja.libreria.client.util.mvp.activity.ActivityBase;
import com.bambuynaranja.libreria.client.util.mvp.view.NameViewEnum;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AltaLibroViewActivity extends ActivityBase implements AltaLibroView.Delegate{

	private Logger log = Logger.getLogger( AltaLibroViewActivity.class.getName() );

	private AltaLibroViewPlace place;

	private AltaLibroView display;

	private AcceptsOneWidget containerWidget;

	public AltaLibroViewActivity() {
		display = (AltaLibroView) Recomienda.getClientSingletonFactoryImpl().getView( NameViewEnum.AltaLibroView );
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
		this.place = (AltaLibroViewPlace) place;
	}

	@Override
	public void guardarLibro() {
		if(display.validate()){
			Libro libro = display.fillObject();
			libro.save();
		}
	}
}
