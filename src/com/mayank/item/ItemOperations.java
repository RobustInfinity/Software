package com.mayank.item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemOperations {

	private  ArrayList<ItemDTO> itemList;
	private static ItemOperations itemOperations =null;
	
	private ItemOperations() {}
	
	public static ItemOperations getInstance() {
		if(itemOperations != null) {
			return itemOperations;
		}
		else {
			itemOperations = new ItemOperations();
			return itemOperations;
		}
	}
	public  ArrayList<ItemDTO> getItemList() throws ClassNotFoundException, SQLException  {
		ItemDAO itemDAO = new ItemDAO();
		this.itemList =  itemDAO.view();
		return itemList;
	}
	
//	public void setItemList() throws ClassNotFoundException, SQLException {
//		ItemDAO itemDAO = new ItemDAO();
//		this.itemList =  itemDAO.view();
//	}
	
			public boolean isFlag(Integer batchNo) throws ClassNotFoundException, SQLException {
				for(ItemDTO itemDTO : getItemList()) {
					if(itemDTO.getBatchNo().equals(batchNo)) {
						if(itemDTO.getStatus().equals("Y")) {
							return true;
						}
				}
			}
			return false;
		}
}
