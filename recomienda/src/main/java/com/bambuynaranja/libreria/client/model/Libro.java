package com.bambuynaranja.libreria.client.model;

import java.util.logging.Logger;

import com.bambuynaranja.libreria.client.dao.idb.model.LibroIDB;
import com.bambuynaranja.libreria.client.model.libro.DatosPrincipales;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.shared.GWT;

public class Libro {
	public static interface LibroMapper extends ObjectMapper<Libro> {}
	private Logger log = Logger.getLogger(Libro.class.getName());
	private LibroMapper mapper;
	
	
	DatosPrincipales datosPrincipales;

	public static Libro createInstance(){
		DatosPrincipales datPral = new DatosPrincipales(null, null, null, null);
		return new Libro(datPral);
	}
	
	@JsonCreator
	private Libro(@JsonProperty("datosPrincipales") DatosPrincipales datosPrincipales) {
		this.mapper = GWT.create(LibroMapper.class);
		this.datosPrincipales = datosPrincipales;
	}

	public DatosPrincipales getDatosPrincipales() {
		return datosPrincipales;
	}

	public void setDatosPrincipales(DatosPrincipales datosPrincipales) {
		this.datosPrincipales = datosPrincipales;
	}
	
	public String toJson(){		
		String json = mapper.write(this);
		return json;
	}
	
	public static Libro fromJson(String json){
		LibroMapper mapper = GWT.create(LibroMapper.class);
		return mapper.read(json);
	}
	
	public void save(){
		LibroIDB.save(this);
	}
	
	
}
