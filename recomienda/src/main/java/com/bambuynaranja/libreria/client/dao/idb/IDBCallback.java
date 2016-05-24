package com.bambuynaranja.libreria.client.dao.idb;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.js.JsType;

@JsType
public class IDBCallback implements Callback{

	@Override
	public void onFailure(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSuccess(Object arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void test(){
		Logger log = Logger.getLogger(IDBCallback.class.getName());
		log.log(Level.INFO, "test");
	}
}
	

