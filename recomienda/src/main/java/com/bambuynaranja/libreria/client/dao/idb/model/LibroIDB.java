package com.bambuynaranja.libreria.client.dao.idb.model;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.bambuynaranja.libreria.client.dao.idb.IndexedDbWrapper;
import com.bambuynaranja.libreria.client.model.Libro;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;

public class LibroIDB {
	
	
	public static void save(final Libro libro){
		final Logger log = Logger.getLogger(LibroIDB.class.getName());
		
		//Se abre la base de datos
		IndexedDbWrapper.openDatabase(new Callback<JavaScriptObject, Void>() {
			
			@Override
			public void onSuccess(JavaScriptObject db) {
				log.log(Level.INFO, "DB: " + db);
				String json = libro.toJson();
				saveNative(db, "libro", json);
			}
			
			@Override
			public void onFailure(Void arg0) {
			}
		});
	}
	
	private static native void saveNative(JavaScriptObject db, String nomObject, String json)/*-{
		var libroObjectStore = db.transaction(nomObject, "readwrite").objectStore(nomObject);
		var obj = JSON.parse(json);		 

		libroObjectStore.add(obj );
	}-*/;
}
