package com.bambuynaranja.libreria.client.mvp.busquedaLibro.view;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.TextBox;

import com.bambuynaranja.libreria.client.model.Libro;
import com.bambuynaranja.libreria.client.util.mvp.view.ViewBase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;

public class BusquedaLibroViewImpl extends ViewBase implements BusquedaLibroView {
	
	private Logger log = Logger.getLogger(BusquedaLibroViewImpl.class.getName());

	
	private static BusquedaLibroViewImplUiBinder uiBinder = GWT.create(BusquedaLibroViewImplUiBinder.class);
	interface BusquedaLibroViewImplUiBinder extends UiBinder<Widget, BusquedaLibroViewImpl> {}
	
	private BusquedaLibroView.Delegate delegate;
	Libro libro = null;
	
	@UiField Button buscarButton;
	@UiField TextBox tituloTextBox;
	@UiField TextBox autorTextBox;
	@UiField TextBox anho1PublicacionTextBox;
	
	public BusquedaLibroViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		if(libro==null){
			libro = Libro.createInstance();
		}
	}


	@Override
	public void setDelegate(Delegate delegate) {
		this.delegate=delegate;
	}
	
	@Override
	public boolean validate() {
		
		return true;
	}


	@Override
	public Libro fillObject() {
		
		return libro;
	}
}
