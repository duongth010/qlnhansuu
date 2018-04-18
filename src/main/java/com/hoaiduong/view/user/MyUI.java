package com.hoaiduong.view.user;



import org.springframework.beans.factory.annotation.Autowired;

import com.hoaiduong.presenter.ContractPresenter;
import com.hoaiduong.presenter.DepartmentPresenter;
import com.hoaiduong.presenter.PartsPresenter;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path="/")
@SuppressWarnings("serial")
@Theme("customtheme")
public class MyUI extends UI {
	
	@Autowired
	private ManagerUser managerUser;
	
	@Autowired
	private SpringViewProvider springViewProvider;
	
	
	@Autowired
	private ContractViewImpl contractViewImpl;
	
	@Autowired
	private ContractPresenter contractPresenter;
	
	
	@Autowired
	private PartsViewImpl partsViewImpl;
	
	@Autowired
	private PartsPresenter partsPresenter;
	
	@Autowired
	private DepartmentViewImpl departmentViewImpl;
	
	@Autowired
	private DepartmentPresenter departmentPresenter;
	
	
	
	
	
	VerticalLayout root;
	
	Navigator navi;
	
	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		root=new VerticalLayout();
		root.addComponent(managerUser);
		
		
		setContent(root);
		navi=new Navigator(this,managerUser.getPanel());
		setNavigator(navi);
		navi.addProvider(springViewProvider);
		navi.setErrorView(ErrorView.class);
		
		contractPresenter.setView(contractViewImpl);
		contractViewImpl.setPresenter(contractPresenter);
		contractViewImpl.init();
	
		partsViewImpl.setPresenter(partsPresenter);
		partsPresenter.setView(partsViewImpl);
		
		partsViewImpl.init();	
		
		
		departmentPresenter.setView(departmentViewImpl);
		departmentViewImpl.setPresenter(departmentPresenter);
		departmentViewImpl.init();
		
		
		
		
		
	}

}
