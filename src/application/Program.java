package application;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import model.entities.Eletronic;
import model.entities.MusicalInstrument;
import model.entities.Product;
import model.entities.ProductManager;
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
		
		Eletronic naoTem = new Eletronic("Mouse", 250.00, 35, 12, LocalDate.parse("2022-02-08"));
		Eletronic jaTem = new Eletronic("Computer", 1500.00, 22, 36, LocalDate.parse("2021-01-07"));
		
		MusicalInstrument jaTemInst = new MusicalInstrument("Piano", 15000.00, 31, Country.PT);
		MusicalInstrument naoTemInst = new MusicalInstrument("Violao", 15000.00, 31, Country.BR);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		ProductManager teste = new ProductManager();
		teste.addProduct(p);
		teste.addProduct(m);
		
		System.out.println(teste.displayProducts());
		
		teste.addProduct(p);
		teste.addProduct(naoTem);
		teste.addProduct(jaTemInst);
		teste.addProduct(naoTemInst);
		
		System.out.println(teste.displayProducts());
		
		
		
	}
}