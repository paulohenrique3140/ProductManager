package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void removeFromFile(ProductManager productManager) {
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
			System.out.println("Error: " + e.getMessage());
		}
	}

}
