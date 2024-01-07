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
		if (stock.contains(product)) {
			System.out.println("Product already exists, Cannot add the same product.");
		} else if (stock.stream().anyMatch(x -> x.getId().equals(product.getId()))) {
			System.out.println("Product with the same ID already exists. Cannot add the product.");
		} else {
			stock.add(product);
		}
	}

	public void displayProducts() {
		System.out.println(stock);
	}

	public String findProduct(int id) {
		return stock.stream().filter(x -> x.getId() == id).findFirst().map(Product::toString)
				.orElse("No products were found with the ID " + id);
	}

	public void updateProduct(int id, String newName, Double newPrice) {
		Optional<Product> optionalProduct = stock.stream().filter(product -> product.getId() == id).findFirst();

		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();

			if (newName != null) {
				boolean nameExists = stock.stream().anyMatch(p -> p.getId() != id && p.getName().toUpperCase().equals(newName.toUpperCase()));
				if (!nameExists) {
					product.setName(newName);
					System.out.println("Product name updated successfully.");
				} else {
					System.out.println("Product with the same name already exists. Update failed.");
				}
			}

			if (newPrice != null) {
				product.setPrice(newPrice);
				System.out.println("Product price updated successfully.");
			}

			System.out.println("Updated Product:\n" + product);
		} else {
			System.out.println("No products were found with the ID " + id + ". Update failed.");
		}
	}

	public void removeProduct(int id) {
		if (!stock.stream().anyMatch(x -> x.getId().equals(id))) {
			System.out.println("No products were found with the ID " + id);
		} else {
			stock.removeIf(product -> product.getId() == id);
			System.out.println("Removed successfully!");
			System.out.println(stock);
		}
	}
}