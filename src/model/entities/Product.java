package model.entities;

import java.util.Objects;

public abstract class Product implements IProduct {
	
	private String name;
	private Double price;
	private Integer id;
	
	public Product(String name, Double price, Integer id) {
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
}
