package model.entities;

import java.util.Objects;

import exceptions.CustomException;
import exceptions.ProductException;

public abstract class Product implements IProduct, Comparable<Product> {
	
	private String name;
	private Double price;
	private Integer id;
	
	public Product(String name, Double price, Integer id) {
		if (price < 0 || id < 0) {
			throw new ProductException("The price cannot be less than zero. Enter and try again.");
		}
		if (id <= 0) {
			throw new CustomException("The id cannot be less than zero. Enter and try again.");
		}
		
		this.name = name;
		this.price = price;
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	@Override
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	
	@Override
	public String toString() {
		return String.format("\nName: %s | Price: BRL %.2f | ID: %d\n", name, price, id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Product other) {
		return name.toUpperCase().compareTo(other.getName().toUpperCase());
	}
}
