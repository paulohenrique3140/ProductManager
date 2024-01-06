package application;

import java.time.LocalDate;

import model.entities.Eletronic;
import model.entities.MusicalInstrument;
import model.entities.enums.Country;

public class Program {
	public static void main(String[] args) {
		
		Eletronic p = new Eletronic("Computer", 1500.00, 22, 36, LocalDate.parse("2021-01-07"));
		System.out.println(p.checkGuarantee());
		System.out.println(p.getName());
		System.out.println(p.getId());
		System.out.println(p.getPrice());
		
		MusicalInstrument m = new MusicalInstrument("Piano", 15000.00, 31, Country.PT);
		System.out.println(m.checkTax());
		System.out.println(m.getName());
		System.out.println(m.getId());
		System.out.println(m.getPrice());
		
		
	}
}