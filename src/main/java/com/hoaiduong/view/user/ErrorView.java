package com.hoaiduong.view.user;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
@UIScope
@SpringView(name=ErrorView.VIEW_NAME)
public class ErrorView extends VerticalLayout implements View{
	public static final String VIEW_NAME="";
	
	@PostConstruct
	public void init() {
		addComponent(new Label("This is the error view - Oops!"));
	}
	

}
