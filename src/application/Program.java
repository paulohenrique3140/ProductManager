package application;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

		ProductManager pm = new ProductManager();

		int option = -1;

		do {
			System.out.println("\n#### PRODUCT MANAGER ####");
			try {
				System.out.print("\nMenu: \n"
						+ "[1] Add product\n[2] Show product list\n[2] Update product\n[3] Remove product\n[4] Work with files\n"
						+ "[5] Check eletronic guarantee\n[6] Check instrument tax\n[0] Exit\n");
				System.out.print("\nChoose an option: ");
				option = sc.nextInt();
				option = validateOption(option, 6);

				switch (option) {
				case 1:
					System.out.println("\n### ADD PRODUCT ###");
					System.out.print("\n[1] Eletronic\n[2] Musical Instrument\n[0] Return to previous menu\n");
					System.out.print("\nChoose an option: ");
					int addProductOption = sc.nextInt();
					addProductOption = validateOption(addProductOption, 2);
					if (addProductOption != 0) {
						System.out.print("\nName: ");
						sc.nextLine();
						String name = sc.nextLine();
						System.out.print("Price: $ ");
						double price = sc.nextDouble();
						System.out.print("ID: ");
						int id = sc.nextInt();

						if (addProductOption == 1) {
							System.out.print("Guarantee [months, > 0]: ");
							int guarantee = sc.nextInt();
							sc.nextLine();
							System.out.print("Purchase date [YYYY-MM-DD]: ");
							String purchaseDate = sc.nextLine();
							Eletronic product = new Eletronic(name, price, id, guarantee,
									LocalDate.parse(purchaseDate));
							pm.addProduct(product);
						} else {
							sc.nextLine();
							System.out.print("Country of origin: ");
							String country = sc.nextLine();
							MusicalInstrument product = new MusicalInstrument(name, price, id, country.toUpperCase());
							pm.addProduct(product);
						}
					}
					break;
				case 2:
					pm.displayProducts();
					break;
				}
			} catch (ProductException e) {
				System.out.println("Error: " + e.getMessage());
				sc.nextLine();
			} catch (EletronicException e) {
				System.out.println("Error: " + e.getMessage());
				sc.nextLine();
			} catch (MusicalInstrumentException e) {
				System.out.println("Error: " + e.getMessage());
				sc.nextLine();
			} catch (CustomException e) {
				System.out.println("Error: " + e.getMessage());
				sc.nextLine();
			} catch (DateTimeParseException e) {
				System.out.println("Error: Invalid format date or invalid date. "
						+ "Enter and try again with a valid date and in format 'YYYY-MM-DD.");
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Error: Invalid data. Enter and try again.");
				sc.nextLine();
			}
		} while (option != 0);
		sc.close();

	}

	public static int validateOption(int option, int limit) {
		Scanner input = new Scanner(System.in);

		while (option < 0 || option > limit) {
			System.out.print("\nInvalid option. Try again: ");
			option = input.nextInt();
		}
		return option;
	}
}
