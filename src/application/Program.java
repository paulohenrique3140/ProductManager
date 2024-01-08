package application;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import exceptions.CustomException;
import exceptions.EletronicException;
import exceptions.MusicalInstrumentException;
import exceptions.ProductException;
import model.entities.Eletronic;
import model.entities.MusicalInstrument;
import model.entities.ProductManager;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		ProductManager testeException = new ProductManager();
		double price = -1.0;
		int guarantee = -1;
		String country = "BC";
		int id = 0;
		
		do {
			try {
				Eletronic testPrice = new Eletronic("PC", price, 1, 12, LocalDate.parse("2023-02-05"));
				Eletronic testGuarantee = new Eletronic("CPU", 1500.00, 2, guarantee, LocalDate.parse("2023-02-05"));
				Eletronic testId = new Eletronic("Mouse", 45.00, id, 15, LocalDate.parse("2023-02-05"));
				MusicalInstrument testCountry = new MusicalInstrument("Viola", 650.00, 5, country);
				
				testeException.addProduct(testPrice);
				testeException.addProduct(testGuarantee);
				testeException.addProduct(testId);
				testeException.addProduct(testCountry);
				
				
			} catch (ProductException e) {
				System.out.println("Error: " + e.getMessage());
				price = sc.nextDouble();
			} catch (EletronicException e) {
				System.out.println("Error: " + e.getMessage());
				guarantee = sc.nextInt();
			} catch (MusicalInstrumentException e) {
				sc.nextLine();
				System.out.println("Error: " + e.getMessage());
				country = sc.nextLine();
			} catch (CustomException e) {
				System.out.println("Error: " + e.getMessage());
				id = sc.nextInt();
			} 
		} while (testeException.getStock().size() == 0);
		
		
		
	}
	
}