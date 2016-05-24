package com.bambuynaranja.libreria.client.mvp.top.activity;

import java.util.logging.Logger;

import com.bambuynaranja.libreria.client.Recomienda;
import com.bambuynaranja.libreria.client.mvp.top.view.TopView;
import com.bambuynaranja.libreria.client.util.mvp.activity.ActivityBase;
import com.bambuynaranja.libreria.client.util.mvp.view.NameViewEnum;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;


public class TopActivity extends ActivityBase implements TopView.Delegate {

	private Logger log = Logger.getLogger( TopActivity.class.getName() );

	private Place place;
	private TopView display;
	private AcceptsOneWidget containerWidget;
	private EventBus eventBus;

	public TopActivity() {
		display = (TopView) Recomienda.getClientSingletonFactoryImpl().getView( NameViewEnum.TopView );
		display.setDelegate(this);
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		this.eventBus = eventBus;
		this.containerWidget = containerWidget;
		containerWidget.setWidget(display.asWidget());
		
	}

	@Override
	public void initActivity(Place place) {
		this.place = place;
	}

	public void selectInicio() {
		display.selectInicio();
	}
	public void selectAltaLibro() {
		display.selectAltaLibro();
	}
	public void selectBusquedaLibro(){
		display.selectBusquedaLibro();
	}
	
}