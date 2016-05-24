package com.bambuynaranja.libreria.client.mvp.altaLibro.view;

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

public class AltaLibroViewImpl extends ViewBase implements AltaLibroView {
	
	private Logger log = Logger.getLogger(AltaLibroViewImpl.class.getName());

	
	private static AltaLibroViewImplUiBinder uiBinder = GWT.create(AltaLibroViewImplUiBinder.class);
	interface AltaLibroViewImplUiBinder extends UiBinder<Widget, AltaLibroViewImpl> {}
	
	private AltaLibroView.Delegate delegate;
	Libro libro = null;
	
	@UiField Button guardarButton;
	@UiField TextBox tituloTextBox;
	@UiField TextBox autorTextBox;
	@UiField TextBox anho1PublicacionTextBox;
	@UiField TextBox idiomaOriginalTextBox;
	
	public AltaLibroViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		if(libro==null){
			libro = Libro.createInstance();
		}
	}


	@Override
	public void setDelegate(Delegate delegate) {
		this.delegate=delegate;
	}


	@UiHandler("guardarButton")
	public void onGuardarButtonClick(ClickEvent clickEvent){
		log.log(Level.INFO, "Guardar click");
		delegate.guardarLibro();
	}
	
	@Override
	public boolean validate() {
		
		return true;
	}


	@Override
	public Libro fillObject() {
		libro.getDatosPrincipales().setTitulo(tituloTextBox.getValue());
		libro.getDatosPrincipales().setAutor(autorTextBox.getValue());
		libro.getDatosPrincipales().setAnioPrimeraPublicacion(anho1PublicacionTextBox.getValue());
		libro.getDatosPrincipales().setIdiomaOriginal(idiomaOriginalTextBox.getValue());
		
		return libro;
	}
}
