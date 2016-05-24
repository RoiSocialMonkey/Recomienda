package com.bambuynaranja.libreria.client.mvp.busquedaLibro.view;

import com.bambuynaranja.libreria.client.model.Libro;
import com.google.gwt.user.client.ui.IsWidget;

public interface BusquedaLibroView extends IsWidget {
	
	public interface Delegate {

	}

	void setDelegate(Delegate delegate);
	
	boolean validate();

	Libro fillObject();
	
}
