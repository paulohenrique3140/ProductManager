package model.entities;

import java.util.Map;
import java.util.Optional;

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
	
	private static final Map<Country, Double> TAX_RATES = Map.of(
			Country.US, 0.25,
			Country.UK, 0.25,
			Country.CN, 0.40,
			Country.PT, 0.40,
			Country.BR, 0.10,
			Country.CO, 0.10
		);
	
	public Double checkTax() {
		return Optional.ofNullable(TAX_RATES.get(country)).map(rate -> getPrice() + (getPrice() * rate)).orElse(null);
	}
}
