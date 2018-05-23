package com.exerciseV1.model;

public class Product {
	private int id;
	private String name;
	private double price;
	private int categorypath;
	private boolean available;

	public Product() {
		
	}
	public Product(int id, String name, double price, int categoryPath, boolean available) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.categorypath = categoryPath;
		this.available = available;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategoryPath() {
		return categorypath;
	}
	public void setCategoryPath(int categoryPath) {
		this.categorypath = categoryPath;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
}
