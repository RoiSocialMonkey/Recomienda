package com.bambuynaranja.libreria.client.dao.idb;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;


public class IndexedDbWrapper {
	
	public static native void checkBrowser()/*-{
	
		if (!window.indexedDB) {
		    console.log("Your browser doesn't support a stable version of IndexedDB. Such and such feature will not be available.");
		} else {
		     console.log("Your browser support a stable version of IndexedDB.");
		 }
	}-*/;
	
	public static native void openDatabase(Callback<JavaScriptObject,Void> callback)/*-{
	
		// Let us open our database
		var request = window.indexedDB.open("RecomiendaApp", 3);
		
		request.onerror = function(event) {
  			// Do something with request.errorCode!
  			console.log("Error opening database");
  			
  			callback.@com.google.gwt.core.client.Callback::onFailure(Ljava/lang/Object;)(request.errorCode);
		};
		request.onsuccess = function(event) {
		  	// Do something with request.result!
		  	var db = event.target.result;
		  	console.log("Database successfully opened: " + db);
		 	callback.@com.google.gwt.core.client.Callback::onSuccess(Ljava/lang/Object;)(db);
		  
		};
		request.onupgradeneeded = function(event) { 
  			var db = event.target.result;
			
			db.deleteObjectStore("libro");

  			// Create an objectStore for this database
  			var objectStore = db.createObjectStore("libro", { autoIncrement : true });
  		};
		
	}-*/;
	
}
