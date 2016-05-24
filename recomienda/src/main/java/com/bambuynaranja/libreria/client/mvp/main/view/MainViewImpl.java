package com.bambuynaranja.libreria.client.mvp.main.view;

import com.bambuynaranja.libreria.client.util.mvp.view.ViewBase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class MainViewImpl extends ViewBase implements MainView  {
	private static MainViewImplUiBinder uiBinder = GWT.create(MainViewImplUiBinder.class);
	interface MainViewImplUiBinder extends UiBinder<Widget, MainViewImpl> {}

	
	public MainViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		
	}
}