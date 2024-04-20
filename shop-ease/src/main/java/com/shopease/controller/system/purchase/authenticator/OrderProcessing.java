package com.shopease.controller.system.purchase.authenticator;

import java.util.List;

import com.shopease.controller.system.stock.Product;

public class OrderProcessing {
	private List<Product> products;
	private double totalPrice;
	private String shippingInfo;
	private String paymentMethod;

	public OrderProcessing(List<Product> products, double totalPrice, String shippingInfo, String paymentMethod) {
		this.products = products;
		this.totalPrice = totalPrice;
		this.shippingInfo = shippingInfo;
		this.paymentMethod = paymentMethod;
	}

	public String getOrderSummary() {
		StringBuilder summary = new StringBuilder();
		summary.append("Order Summary:\n");
		summary.append("Products:\n");
		for (Product product : products) {
			summary.append("- ").append(product.getName()).append(": $").append(product.getPrice()).append("\n");
		}
		summary.append("Total Price: $").append(totalPrice).append("\n");
		summary.append("Shipping Information: ").append(shippingInfo).append("\n");
		summary.append("Payment Method: ").append(paymentMethod).append("\n");
		return summary.toString();
	}
}

