package model.entities;

import model.entities.enums.Country;

public class MusicalInstrument extends Product {
	
	private Country country;

	public MusicalInstrument(String name, Double price, Integer id, Country country) {
		super(name, price, id);
		this.country = country;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Double checkTax() {
		if (country != null) {
			switch (country) {
			case US, UK:
				return getPrice() + (getPrice() * 0.25);
			case CN, PT:
				return getPrice() + (getPrice() * 0.40);
			case BR, CO:
				return getPrice() + (getPrice() * 0.10);
			default:
				break;
			}
		}
		return null;
	}
	
}
