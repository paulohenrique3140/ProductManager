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
import files.FileService;
import model.entities.Eletronic;
import model.entities.MusicalInstrument;
import model.entities.Product;
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
						+ "[1] Add product\n[2] Show product list\n[3] Update product\n[4] Remove product\n[5] Check eletronic guarantee\n"
						+ "[6] Check instrument tax\n[7] Work with files\n[0] Exit\n");
				System.out.print("\nChoose an option: ");
				option = sc.nextInt();
				option = validateOption(sc, option, 7);

				switch (option) {
				case 1:
					System.out.println("\n### ADD PRODUCT ###");
					System.out.print("\n[1] Eletronic\n[2] Musical Instrument\n[0] Return to previous menu\n");
					System.out.print("\nChoose an option: ");
					int addProductOption = sc.nextInt();
					addProductOption = validateOption(sc, addProductOption, 2);
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
				case 3:
					System.out.println("### UPDATE PRODUCT ###");
					System.out.print(
							"\n[1] Update name\n[2] Update price\n[3] Update both\n[0] Return to previous menu\n");
					System.out.print("\nChoose an option: ");
					int updateOption = sc.nextInt();
					updateOption = validateOption(sc, updateOption, 3);
					if (updateOption != 0) {
						System.out.print("\nType the product ID: ");
						int updateId = sc.nextInt();
						switch (updateOption) {
						case 1:
							System.out.print("\nEnter new name: ");
							sc.nextLine();
							String updateName = sc.nextLine();
							pm.updateProduct(updateId, updateName, null);
							break;
						case 2:
							System.out.print("\nEnter new price: ");
							double updatePrice = sc.nextDouble();
							pm.updateProduct(updateId, null, updatePrice);
							break;
						default:
							System.out.print("\nEnter new name: ");
							sc.nextLine();
							updateName = sc.nextLine();
							System.out.print("\nEnter new price: ");
							updatePrice = sc.nextDouble();
							pm.updateProduct(updateId, updateName, updatePrice);
							break;
						}
					}
					break;
				case 4:
					System.out.println("### REMOVING PRODUCTS ###");
					pm.displayProducts();
					System.out.print("\nEnter the ID of the product to be removed: ");
					int removeId = sc.nextInt();
					pm.removeProduct(removeId);
					System.out.println("\n### Updated product list ###");
					pm.displayProducts();
					break;
				case 5:
					System.out.println("\n### CHECKING ELETRONIC PRODUCT GUARANTEE ###");
					System.out.print("\nEnter product ID: ");
					int checkGuarantee = sc.nextInt();
					Product foundProduct = pm.findProduct(checkGuarantee);
					if (foundProduct != null && foundProduct instanceof Eletronic) {
						Eletronic eletronicProduct = (Eletronic) foundProduct;

						if (eletronicProduct.checkGuarantee()) {
							System.out.println("The product still in guarantee.");
						} else {
							System.out.println("The product doesn't have guarantee anyumore.");
						}
					} else {
						System.out.println("No Eletronic product found with the ID " + checkGuarantee);
					}
					break;
				case 6:
					System.out.println("\n### CHECKING MUSICAL INSTRUMENT TAX ###");
					System.out.print("\nEnter product ID: ");
					int checkTax = sc.nextInt();
					foundProduct = pm.findProduct(checkTax);
					if (foundProduct != null && foundProduct instanceof MusicalInstrument) {
						MusicalInstrument musicalProduct = (MusicalInstrument) foundProduct;

						if (musicalProduct.checkTax() != null) {
							System.out.println(pm.findProduct(checkTax));
							System.out.printf("Tax: BRL %.2f\n", musicalProduct.checkTax());
						}
					}
					break;
				case 7:
					System.out.println("\n### WORKING WITH FILES ###");
					System.out.print("\nBefore we begin, please enter the path with which you will work with files: ");
					sc.nextLine();
					String path = sc.nextLine();
					System.out.print("Now, enter the file name [Ex: file.txt]: ");
					String fileName = sc.nextLine();
					FileService fs = new FileService(path);
					System.out.print(
							"\n[1] Download a file with product list\n[2] Delete load\n[3] Update load\n[4] Insert load\n"
									+ "[0] Return to main menu\n");
					System.out.print("\nChoose an option: ");
					int fileOption = sc.nextInt();
					fileOption = validateOption(sc, fileOption, 4);
					if (fileOption != 0) {
						switch (fileOption) {
						case 1:
							fs.writeToFile(pm, fileName);
							break;
						case 2:
							fs.deleteFromFile(pm, fileName);
							break;
						case 3:
							fs.updateFromFile(pm, fileName);
							break;
						case 4:
							fs.insertFromFile(pm, fileName);
							break;
						default:
							break;
						}
					}
					break;
				default:
					System.out.println(
							"\n### Thank you for using our app, we're at your disposal if you have any questions. ###");
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

	public static int validateOption(Scanner scanner, int option, int limit) {
		while (option < 0 || option > limit) {
			System.out.print("\nInvalid option. Try again: ");
			option = scanner.nextInt();
		}
		return option;
	}
}
