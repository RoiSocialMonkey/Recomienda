package com.bambuynaranja.libreria.client.mvp.main.activity;

import java.util.logging.Logger;

import com.bambuynaranja.libreria.client.Recomienda;
import com.bambuynaranja.libreria.client.mvp.main.place.MainViewPlace;
import com.bambuynaranja.libreria.client.mvp.main.view.MainView;
import com.bambuynaranja.libreria.client.util.mvp.activity.ActivityBase;
import com.bambuynaranja.libreria.client.util.mvp.view.NameViewEnum;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class MainViewActivity extends ActivityBase {

	private Logger log = Logger.getLogger( MainViewActivity.class.getName() );

	private MainViewPlace place;

	private MainView display;

	private AcceptsOneWidget containerWidget;

	public MainViewActivity() {
		display = (MainView) Recomienda.getClientSingletonFactoryImpl().getView( NameViewEnum.MainView );
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		this.containerWidget = containerWidget;
		containerWidget.setWidget(display.asWidget());
	}

	@Override
	public void initActivity(Place place) {
		this.place = (MainViewPlace) place;
	}
}