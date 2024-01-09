package application;

import java.time.LocalDate;
import java.util.InputMismatchException;
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
		double price = 0.00;
		int guarantee = 0;
		String country = " ";
		int id = 0;
		int ans = 1;

		do {
			try {
				System.out.print("DIGITE O PRECO: ");
				price = sc.nextDouble();
				Eletronic testPrice = new Eletronic("PC", price, 1, 12, LocalDate.parse("2023-02-05"));
				testeException.addProduct(testPrice);
				
				System.out.println();
				System.out.println();
				System.out.print("DIGITE A GARANTIA: ");
				guarantee = sc.nextInt();
				Eletronic testGuarantee = new Eletronic("CPU", 1500.00, 2, guarantee, LocalDate.parse("2023-02-05"));
				testeException.addProduct(testGuarantee);
				sc.nextLine();
				
				System.out.println();
				System.out.println();
				System.out.print("DIGITE O COUNTRY: ");				
				country = sc.nextLine();
				MusicalInstrument testCountry = new MusicalInstrument("Viola", 650.00, 5, country.toUpperCase());
				testeException.addProduct(testCountry);
				
				System.out.println();
				System.out.println();
				System.out.print("DIGITE O ID: ");
				id = sc.nextInt();
				Eletronic testId = new Eletronic("Mouse", 45.00, id, 15, LocalDate.parse("2023-02-05"));
				testeException.addProduct(testId);
				System.out.println();
				System.out.println("Digite ANS: ");
				ans = sc.nextInt();
			} catch (ProductException e) {
				System.out.println("Error: " + e.getMessage());
				sc.nextLine();
			} catch (EletronicException e) {
				System.out.println("Error: " + e.getMessage());
				sc.nextLine();
			} catch (MusicalInstrumentException e) {
				sc.nextLine();
				System.out.println("Error: " + e.getMessage());
				sc.nextLine();
			} catch (CustomException e) {
				System.out.println("Error: " + e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Error: Invalid data. Try again.");
				sc.nextLine();
			}
		} while (ans != 0);

		sc.close();

	}
}
