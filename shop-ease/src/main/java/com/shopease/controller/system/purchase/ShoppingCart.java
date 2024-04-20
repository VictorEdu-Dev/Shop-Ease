package com.controller.system.purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.controller.system.purchase.authenticator.OrderProcessing;
import com.controller.system.stock.Product;

public final class ShoppingCart {
	private List<Product> listProduct;
	private Map<String, Double> subTotalByCategory;
	private double priceTotalOfProduct;
	private String summaryOrder;

	public ShoppingCart() {
		setListProduct(new ArrayList<Product>());
	}

	public boolean addProduct(Product product) {
		return getListProduct().add(product);
	}

	public boolean removeProduct(Product product) {
		return getListProduct().remove(product);
	}
	
	public void removeAllProducts() {
		getListProduct().clear();
	}

	public boolean replaceProduct(Product productReplace, Product productRemove) {
		boolean removed;
		boolean replaced;

		removed = getListProduct().remove(productRemove);
		replaced = getListProduct().add(productReplace);

		return removed && replaced;
	}

	public Map<String, Double> calculateSubtotalByCategory() {
		return getListProduct().stream()
				.collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));
	}

	public double calculateTotalPriceProducts() {
		setPriceTotalOfProduct(
				getSubtotalByCategory().values().stream()
				.mapToDouble(Double::doubleValue)
				.sum());
		return getPriceTotalOfProduct();
	}

	public void generateOrderSummary(String shippingInfo, String paymentMethod) {
		OrderProcessing orderProcessing = new OrderProcessing(listProduct, priceTotalOfProduct, shippingInfo, paymentMethod);
        setSummaryOrder(orderProcessing.getOrderSummary());
    }

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public Map<String, Double> getSubtotalByCategory() {
		return subTotalByCategory;
	}

	public double getPriceTotalOfProduct() {
		return priceTotalOfProduct;
	}

	public void setPriceTotalOfProduct(double priceTotalOfProduct) {
		this.priceTotalOfProduct = priceTotalOfProduct;
	}

	public Map<String, Double> getSubTotalByCategory() {
		return subTotalByCategory;
	}

	public void setSubTotalByCategory(Map<String, Double> subTotalByCategory) {
		this.subTotalByCategory = subTotalByCategory;
	}

	public String getSummaryOrder() {
		return summaryOrder;
	}

	public void setSummaryOrder(String summaryOrder) {
		this.summaryOrder = summaryOrder;
	}
}

