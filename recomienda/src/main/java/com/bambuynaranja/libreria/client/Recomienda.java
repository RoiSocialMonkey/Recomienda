package com.bambuynaranja.libreria.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.bambuynaranja.libreria.client.dao.idb.IndexedDbWrapper;
import com.bambuynaranja.libreria.client.mvp.main.place.MainViewPlace;
import com.bambuynaranja.libreria.client.util.mvp.activity.ActivityMapperMain;
import com.bambuynaranja.libreria.client.util.mvp.activity.ActivityMapperTop;
import com.bambuynaranja.libreria.client.util.mvp.place.AppPlaceHistoryMapper;
import com.bambuynaranja.libreria.client.util.mvp.view.ViewSingletonFactoryImpl;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Recomienda implements EntryPoint {
	private Logger log = Logger.getLogger(Recomienda.class.getName());
	
	private static ViewSingletonFactoryImpl clientSingletonFactoryImpl;

	private SimplePanel topPanel = new SimplePanel();
	private SimplePanel mainPanel = new SimplePanel();
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
	
		log.log(Level.INFO, "Inicializando aplicación");
		
		iniciarApliacion();
		
	}
	
	public void iniciarApliacion(){
		log.log(Level.INFO, "Aplicación lanzada");

		//capturamos cualquier excepcion no contralada
		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
			
			@Override
			public void onUncaughtException(Throwable e) {
				log.log(Level.SEVERE, "Excepcion no controlada, capturada por UncaughtExceptionHandler", e);
				
				//String msg = e.getMessage() != null ? e.getMessage() : "";
				//GWT.log("Excepcion no controlada, capturada por UncaughtExceptionHandler. " + msg, e);
			}
		});
				
		
		clientSingletonFactoryImpl = new ViewSingletonFactoryImpl();
		EventBus eventBus = clientSingletonFactoryImpl.getEventBus();
		PlaceController placeController = clientSingletonFactoryImpl.getPlaceController();

		// Start Mappers and  Managers
		// Top
		ActivityMapper activityMapperTop = new ActivityMapperTop();
		ActivityManager activityManagerTop = new ActivityManager(activityMapperTop, eventBus);
		activityManagerTop.setDisplay( topPanel );

		//Sección principal
		ActivityMapper activityMapperMain = new ActivityMapperMain();
		ActivityManager activityManagerMain = new ActivityManager(activityMapperMain, eventBus);
		activityManagerMain.setDisplay( mainPanel );

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		final AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);

		//controlamos los cambios de url
		eventBus.addHandler( PlaceChangeEvent.TYPE, new PlaceChangeEvent.Handler() {
			@Override
			public void onPlaceChange(PlaceChangeEvent event) {
				String token = historyMapper.getToken( event.getNewPlace() );
				log.log(Level.FINE, "nuevo place: " + token );
			}
		});

		historyHandler.register(placeController, eventBus,  new MainViewPlace() );

		RootPanel.get("top_navegacion").add(topPanel);
		RootPanel.get("main_container").add(mainPanel);

		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();
		
		log.log(Level.INFO, "Aplicación arrancada");
		
		IndexedDbWrapper.checkBrowser();
		IndexedDbWrapper.openDatabase(new Callback<JavaScriptObject, Void>() {
			
			@Override
			public void onSuccess(JavaScriptObject arg0) {
				log.log(Level.INFO, "DB: " + arg0);
			}
			
			@Override
			public void onFailure(Void arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	public static ViewSingletonFactoryImpl getClientSingletonFactoryImpl() {
		return clientSingletonFactoryImpl;
	}

	
}
