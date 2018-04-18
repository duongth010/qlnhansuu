package com.hoaiduong.view.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Tree.ItemClick;
import com.vaadin.ui.Tree.ItemClickListener;

@SpringComponent
@UIScope
public class ManagerUser extends HorizontalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tree<String> dsMenu;
	private TreeData<String> data;
	private Panel panel;

	public Panel getPanel() {
		return panel;
	}


	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	public ManagerUser() {
		
		initTree();
		initPanel();
	}
	
	

	private void initTree() {
		
		dsMenu = new Tree<String>("Manage");
		dsMenu.setWidth("350px");
		data = new TreeData<>();
		
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
		dsMenu.expand("Danh Mục");
		addComponent(dsMenu);
		dsMenu.addItemClickListener(new ItemClickListener<String>() {
			
			@Override
			public void itemClick(ItemClick<String> event) {
				// TODO Auto-generated method stub
				String viewName=event.getItem();
				switch (viewName) {
				case "Hợp Đồng":
					getUI().getNavigator().navigateTo(ContractViewImpl.VIEW_NAME);
					
					break;
				case "Bộ Phận":
					getUI().getNavigator().navigateTo(PartsViewImpl.VIEW_NAME);
					break;
					
				case "Phòng Ban":
					getUI().getNavigator().navigateTo(DepartmentViewImpl.VIEW_NAME);
					break;
					
				case "Quản Lý Hồ Sơ Nhân Sự":
					getUI().getNavigator().navigateTo(EmployeeViewImpl.VIEW_NAME);
					break;

				default:
					break;
				}
				
			}
		});
		
		
	}



	private void initPanel() {
		panel=new Panel("Panel");
		panel.setSizeFull();
		panel.setWidth("900px");
		panel.setHeightUndefined();
		
		
		addComponent(panel);	
		
	}


	
	 



	
	
}
