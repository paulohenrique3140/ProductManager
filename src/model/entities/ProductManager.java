package model.entities;

import java.util.Set;
import java.util.TreeSet;

public class ProductManager {
	
	private Set<Product> stock;
	
	public ProductManager() {
		stock = new TreeSet<>();
	}
	
	public void addProduct(Product product) {
		stock.add(product);
	}
	
	public Set<Product> displayProducts() {
		return stock;
	}
}