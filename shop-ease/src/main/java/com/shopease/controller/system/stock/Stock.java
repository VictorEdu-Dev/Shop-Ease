package com.shopease.controller.system.stock;

import java.util.List;

public interface Stock {
	public Product getElementByIndex(List<Product> list, Integer index);
	
	public Product getElementByName(List<Product> list, String name);
	
	public Integer getNumberElements(List<Product> list);
	

}

