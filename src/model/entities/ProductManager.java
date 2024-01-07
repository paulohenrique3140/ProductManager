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
		stock.add(product);
	}
	
	public Set<Product> displayProducts() {
		return stock;
	}
	
	public String findProduct(int id) {
		Optional<Product> foundProduct = stock.stream().filter(x -> x.getId() == id).findFirst();
		return foundProduct.map(Product::toString).orElse("No products were found with the ID 2 " + id);
	}
	
	public void removeProduct(int id) {
		stock.removeIf(product -> product.getId() == id);
	}
}