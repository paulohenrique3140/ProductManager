package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.Eletronic;
import model.entities.MusicalInstrument;
import model.entities.Product;
import model.entities.ProductManager;

public class FileService {

	private String path;

	public FileService(String path) {
		this.path = path;
	}

	public void writeToFile(ProductManager productManager) {
		String targetFileStr = path + "\\teste.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
			for (Product x : productManager.getStock()) {
				bw.write(x.toString());
			}

		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
	}
	
	public void deleteFromFile(ProductManager productManager) {
		String sourceFileStr = path + "\\cargaDelete.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
			String line = br.readLine();
			List<Integer> idsToRemove = new ArrayList<>();
			
			while (line != null) {
				String[] fields = line.split(",");
				int id = Integer.parseInt(fields[2]);
				
				boolean found = false;
				for (Product x : productManager.getStock()) {
					if (id == x.getId()) {
						idsToRemove.add(id);
						found = true;
						break;
					}
				}
				
				if (!found) {
					System.out.println("No products were found with the ID " + id);
				}
				
				line = br.readLine();
			}
			
			for (Integer id: idsToRemove) {
				productManager.removeProduct(id);
			}
			
			
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
	
	public void updateFromFile(ProductManager productManager) {
		String sourceFileStr = path + "\\cargaUpdate.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
			String line = br.readLine();
			
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Double price = Double.parseDouble(fields[1]);
				int id = Integer.parseInt(fields[2]);
				
				boolean found = false;
				
				for(Product x : productManager.getStock()) {
					if (id == x.getId()) {
						productManager.updateProduct(id, name, price);
						found = true;
						break;
					}
				}
				
				if (!found) {
					System.out.println("No products were found with the ID " + id);
				}
				
				line = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
	
	public void insertFromFile(ProductManager productManager) {
		String sourceFileStr = path + "\\cargaInsert.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){
			String line = br.readLine();
			
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int id = Integer.parseInt(fields[2]);
				
				
				if (fields.length == 4) {
					String country = fields[3].toUpperCase();
					System.out.println("#### ATENCAO #### "+ country);
					productManager.addProduct(new MusicalInstrument(name, price, id, country));	
				} else if (fields.length == 5) {
					int guarantee = Integer.parseInt(fields[3]);
					String date = fields[4];
					productManager.addProduct(new Eletronic(name, price, id, guarantee, LocalDate.parse(date)));					
				} else {
					System.out.println("Error: Invalid data for record type");
				}
				
				line = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
}
