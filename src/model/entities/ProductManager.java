package model.entities;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class ProductManager {
	
	private Set<Product> stock;
	
	public ProductManager() {
		stock = new TreeSet<>();
	}
	
	public Set<Product> getStock() {
		return stock;
	}

	public void addProduct(Product product) {
		if(stock.contains(product)) {
			System.out.println("Product already exists, Cannot add the same product.");
		} else if(stock.stream().anyMatch(x -> x.getId().equals(product.getId() ))) {
			System.out.println("Product with the same ID already exists. Cannot add the product.");
		} else if (stock.stream().anyMatch(x -> x.getName().equals(product.getName()))) {
			System.out.println("Product with the same name already exists. Cannot add the product.");
		} else {
			stock.add(product);
		}
	}
	
	public Set<Product> displayProducts() {
		return stock;
	}
	
	public String findProduct(int id) {
		Optional<Product> foundProduct = stock.stream().filter(x -> x.getId() == id).findFirst();
		return foundProduct.map(Product::toString).orElse("No products were found with the ID " + id);
	}
	
	public void removeProduct(int id) {
		if (!stock.stream().anyMatch(x -> x.getId().equals(id))) {
			System.out.println("No products were found with the ID " + id);
		}
		stock.removeIf(product -> product.getId() == id);
	}
}