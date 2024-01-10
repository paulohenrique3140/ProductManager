package model.entities;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import exceptions.EletronicException;

public class Eletronic extends Product {
	
	private Integer guarantee;
	private LocalDate purchaseDate;
	
	LocalDate today = LocalDate.now();
	
	public Eletronic(String name, Double price, Integer id, Integer guarantee, LocalDate purchaseDate) {
		super(name, price, id);
		if (guarantee < 0) {
			throw new EletronicException("The guarantee cannot be less than zero. Type again: ");
		}
		
		this.guarantee = guarantee;
		this.purchaseDate = purchaseDate;
	}

	public Integer getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(Integer guarantee) {
		this.guarantee = guarantee;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public boolean checkGuarantee() {
		LocalDate today = LocalDate.now();
		long months = ChronoUnit.MONTHS.between(purchaseDate, today);
		if (months >= guarantee) {
			return false;
		}
		return true;
	}
	
	
}
