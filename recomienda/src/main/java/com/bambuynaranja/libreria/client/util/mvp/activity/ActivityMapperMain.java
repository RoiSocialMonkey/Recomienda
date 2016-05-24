package com.bambuynaranja.libreria.client.util.mvp.activity;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bambuynaranja.libreria.client.mvp.altaLibro.activity.AltaLibroViewActivity;
import com.bambuynaranja.libreria.client.mvp.altaLibro.place.AltaLibroViewPlace;
import com.bambuynaranja.libreria.client.mvp.busquedaLibro.activity.BusquedaLibroViewActivity;
import com.bambuynaranja.libreria.client.mvp.busquedaLibro.place.BusquedaLibroViewPlace;
import com.bambuynaranja.libreria.client.mvp.main.activity.MainViewActivity;
import com.bambuynaranja.libreria.client.mvp.main.place.MainViewPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.place.shared.Place;

public class ActivityMapperMain implements ActivityMapper {
	
	Logger log = Logger.getLogger( ActivityMapperMain.class.getName() );

	private HashMap<String, ActivityBase> activities = new HashMap<String, ActivityBase>();
	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	public ActivityMapperMain() {
		super();
	}

	
	@Override
	public Activity getActivity(final Place place) {
		log.log(Level.INFO, "ActivityMapperMain getActivity.");
		ActivityBase activitySave = activities.get( place.getClass().getName() );
		
		
		
		if ( activitySave == null ) {
			if ( place instanceof MainViewPlace ) {
				activitySave = new MainViewActivity();
			} 	else if(place instanceof AltaLibroViewPlace){
				activitySave = new AltaLibroViewActivity();
			}	else if(place instanceof BusquedaLibroViewPlace){
				activitySave = new BusquedaLibroViewActivity();
			}
			activities.put(place.getClass().getName(), activitySave);
		}
		activitySave.initActivity(place);
		//repintarJavaScript();
		return activitySave;
	}
	
	protected void repintarJavaScript(){
		Scheduler.get().scheduleFinally(new ScheduledCommand() {
			
			@Override
			public void execute() {
				//llamadaJavaScript();
			}
		});
	}
	private native void llamadaJavaScript() 
	/*-{
		// initiate layout and plugins
		$wnd.Metronic.init(); // init metronic core components
		$wnd.Layout.init(); // init current layout
		$wnd.UIExtendedModals.init();
		$wnd.Custom.init(); // init current layout
	
	}-*/;
}
