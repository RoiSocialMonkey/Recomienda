package com.bambuynaranja.libreria.client.mvp.altaLibro.view;

import com.bambuynaranja.libreria.client.model.Libro;
import com.google.gwt.user.client.ui.IsWidget;

public interface AltaLibroView extends IsWidget {
	
	public interface Delegate {
		void guardarLibro();

	}

	void setDelegate(Delegate delegate);
	
	boolean validate();

	Libro fillObject();
	
}
