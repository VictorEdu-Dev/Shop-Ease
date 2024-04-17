package com.controller.system.stock;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StockBatch implements Serializable, Stock {
	private static final long serialVersionUID = 6477725379109897982L;
	private String id;
	private List<Product> productList;
	
	public StockBatch() {
	
	}

	@Override
	public Product getElementByIndex(List<Product> list, Integer index) {
		return list.get(index);
	}

	@Override
	public Product getElementByName(List<Product> list, String name) {
		Stream<Product> streamList = list.stream();
		Boolean str = streamList.anyMatch(product -> product.getName().equals(name));
		
		if(str) {
			Optional<Product> getProduct = streamList
                    .filter(product -> product.getName().equals(name))
                    .findFirst();
			return getProduct.get();
		} else {
			return null;
		}
	}

	@Override
	public Integer getNumberElements(List<Product> list) {
		return productList.size();
	}
	
	public String toString() {
		productList.stream().forEach(System.out::println);
		return null;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}

