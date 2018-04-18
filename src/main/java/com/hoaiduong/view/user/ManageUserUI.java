/*package com.hoaiduong.view.user;

import com.vaadin.annotations.Theme;
import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Tree.ItemClick;
import com.vaadin.ui.Tree.ItemClickListener;
import com.vaadin.ui.UI;

@SpringUI(path = "/")
@Theme("customtheme")
@SuppressWarnings("serial")
@SpringViewDisplay
public class ManageUserUI extends UI implements ViewDisplay {

	HorizontalLayout layout;
	Panel springViewDisplay;

	@Override
	protected void init(VaadinRequest request) {
		layout = new HorizontalLayout();
		
		getUI().getNavigator().setErrorView(ViewError.class);
		
		initMenu();
		initPanel();

		setContent(layout);
	}

	private void initPanel() {
		springViewDisplay = new Panel("My Panel");
		springViewDisplay.setSizeFull();
		springViewDisplay.setWidth("900px");
		
		layout.addComponent(springViewDisplay);

	}

	private void initMenu() {

		Tree<String> dsMenu = new Tree<String>("Manage");
		dsMenu.setWidth("350px");
		TreeData<String> data = new TreeData<>();
		data.addItem(null, "Danh Mục");
			data.addItem("Danh Mục", "Hợp Đồng");
			data.addItem("Danh Mục", "Bộ Phận");
			data.addItem("Danh Mục", "Phòng Ban");
			data.addItem("Danh Mục", "Khóa Đào Tạo");
		data.addItem(null, "Quản Lý Hồ Sơ Nhân Sự");
		data.addItem(null, "Quản Lý Đào Tạo");
		data.addItem(null, "Báo Cáo Quản Lý Nhân Sự");
			data.addItem("Báo Cáo Quản Lý Nhân Sự", "Ds Nhân Viên");
			data.addItem("Báo Cáo Quản Lý Nhân Sự", "Ds Nhân Viên Đang Thử Việc");
			data.addItem("Báo Cáo Quản Lý Nhân Sự", "Ds Nhân Viên Hết Hạn Hợp Đồng");
			data.addItem("Báo Cáo Quản Lý Nhân Sự", "Ds Nhân Viên Và Các Khóa Đào Tạo");

		dsMenu.setDataProvider(new TreeDataProvider<>(data));
		
		dsMenu.addItemClickListener(new ItemClickListener<String>() {
			
			@Override
			public void itemClick(ItemClick<String> event) {
				// TODO Auto-generated method stub
				
				String viewName=event.getItem();
				switch (viewName) {
				case "Hợp Đồng":
					switchView("Hợp Đồng");
					break;

				default:
					break;
				}
					
			}
		});
		layout.addComponent(dsMenu);

	}

	private void switchView(String viewname) {
		getUI().getNavigator().navigateTo(viewname);
		
	}

	@Override
	public void showView(View view) {
		 springViewDisplay.setContent((Component) view);
		
	}
	
	

}
*/