package com.bambuynaranja.libreria.client.mvp.top.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface TopView extends IsWidget {

	public interface Delegate{
		
		/*public void rentaPorConceptoSeleccionada();
		public void rentaPorPorcentajeSeleccionada();*/
		
	}
	
	void selectInicio();

	void selectAltaLibro();
	
	void selectBusquedaLibro();
	
	void setDelegate(Delegate topActivity);

}