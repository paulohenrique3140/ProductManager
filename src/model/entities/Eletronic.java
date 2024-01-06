package model.entities;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Eletronic extends Product {
	
	private Integer guarantee;
	private LocalDate purchaseDate;
	
	LocalDate today = LocalDate.now();
	
	public Eletronic(String name, Double price, Integer id, Integer guarantee, LocalDate purchaseDate) {
		super(name, price, id);
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
