package com.bambuynaranja.libreria.client.util.mvp.view;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.Composite;

public abstract class ViewBase extends Composite {

	public ViewBase() {
		super();
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		repintarJavaScript();
	}
	protected void repintarJavaScript(){
		Scheduler.get().scheduleFinally(new ScheduledCommand() {
			
			@Override
			public void execute() {
				//llamadaJavaScript();
			}
		});
	}
	
	
	protected void repintarJavaScriptInitContent(){
		Scheduler.get().scheduleFinally(new ScheduledCommand() {
			
			@Override
			public void execute() {
				//llamadaInitContent();
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
	
	private native void llamadaInitContent() 
	/*-{
		// initiate layout and plugins
		$wnd.Metronic.init(); // init metronic core components
		$wnd.Layout.init(); // init current layout
		$wnd.UIExtendedModals.init();
		$wnd.Custom.initContent(); // init current layout
	}-*/;
	
	
}
