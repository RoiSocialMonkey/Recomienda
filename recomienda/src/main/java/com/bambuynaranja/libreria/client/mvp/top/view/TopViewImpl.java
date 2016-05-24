package com.bambuynaranja.libreria.client.mvp.top.view;

import com.bambuynaranja.libreria.client.mvp.altaLibro.place.AltaLibroViewPlace;
import com.bambuynaranja.libreria.client.mvp.busquedaLibro.place.BusquedaLibroViewPlace;
import com.bambuynaranja.libreria.client.mvp.main.place.MainViewPlace;
import com.bambuynaranja.libreria.client.util.mvp.view.ViewBase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class TopViewImpl extends ViewBase implements TopView  {
	private static TopViewImplUiBinder uiBinder = GWT.create(TopViewImplUiBinder.class);
	interface TopViewImplUiBinder extends UiBinder<Widget, TopViewImpl> {}

	Delegate delegate;
	
	@UiField LIElement inicioLi;
	@UiField AnchorElement inicioAnchor;
	@UiField LIElement altaLibroLi;
	@UiField AnchorElement altaLibroAnchor;
	@UiField LIElement busquedaLibroLi;
	@UiField AnchorElement busquedaLibroAnchor;

	/*
	@UiField SpanElement versionSpan;
	*/
	
	public TopViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	
		inicioAnchor.setHref(MainViewPlace.getUrl());
		altaLibroAnchor.setHref(AltaLibroViewPlace.getUrl());
		busquedaLibroAnchor.setHref(BusquedaLibroViewPlace.getUrl());
	}
	
	@Override
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
		
	}
	
	
	private void removeSelects(){
		inicioLi.removeClassName("active");
		altaLibroLi.removeClassName("active");
		busquedaLibroLi.removeClassName("active");
	}

	@Override
	public void selectInicio() {
		removeSelects();
		inicioLi.addClassName("active");
	}

	@Override
	public void selectAltaLibro() {
		removeSelects();
		altaLibroLi.addClassName("active");
	}

	@Override
	public void selectBusquedaLibro() {
		removeSelects();
		busquedaLibroLi.addClassName("active");
		
	}

}