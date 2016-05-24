package com.bambuynaranja.libreria.client.model.libro;

import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.shared.GWT;

public class DatosPrincipales {
	public static interface DatosPralMapper extends ObjectMapper<DatosPrincipales> {}
	private Logger log = Logger.getLogger(DatosPrincipales .class.getName());
	private DatosPralMapper mapper;
	
	String titulo;
	String autor;
	String anioPrimeraPublicacion;
	String idiomaOriginal;
	
	
	@JsonCreator
	public DatosPrincipales(
			@JsonProperty("titulo") String titulo, 
			@JsonProperty("autor") String autor, 
			@JsonProperty("anioPrimeraPublicacion") String anioPrimeraPublicacion, 
			@JsonProperty("idiomaOriginal") String idiomaOriginal) {
		this.mapper = GWT.create(DatosPralMapper.class);
		this.titulo = titulo;
		this.autor = autor;
		this.anioPrimeraPublicacion = anioPrimeraPublicacion;
		this.idiomaOriginal = idiomaOriginal;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAnioPrimeraPublicacion() {
		return anioPrimeraPublicacion;
	}
	public void setAnioPrimeraPublicacion(String anioPrimeraPublicacion) {
		this.anioPrimeraPublicacion = anioPrimeraPublicacion;
	}
	public String getIdiomaOriginal() {
		return idiomaOriginal;
	}
	public void setIdiomaOriginal(String idiomaOriginal) {
		this.idiomaOriginal = idiomaOriginal;
	}
	
	public String toJson(){		
		String json = mapper.write(this);
		return json;
	}
	
	public static DatosPrincipales fromJson(String json){
		DatosPralMapper mapper = GWT.create(DatosPralMapper.class);
		return mapper.read(json);
	}
	
}
