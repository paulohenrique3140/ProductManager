package application;

import java.time.LocalDate;

import files.FileService;
import model.entities.Eletronic;
import model.entities.MusicalInstrument;
import model.entities.ProductManager;
import model.entities.enums.Country;

public class Program {
	public static void main(String[] args) {

		Eletronic p = new Eletronic("Computer", 1500.00, 22, 36, LocalDate.parse("2021-01-08"));
		MusicalInstrument m = new MusicalInstrument("Piano", 15000.00, 31, Country.PT);

		Eletronic naoTem = new Eletronic("Mouse", 250.00, 35, 3, LocalDate.parse("2022-02-08"));
		Eletronic jaTem = new Eletronic("Computer", 1500.00, 22, 36, LocalDate.parse("2021-01-07"));

		MusicalInstrument naoTemInst = new MusicalInstrument("Violao", 900.00, 99, Country.BR);
		MusicalInstrument jaTemInst = new MusicalInstrument("Piano", 15000.00, 31, Country.PT);

		Eletronic jaTemNome = new Eletronic("Computer", 3200.00, 102, 24, LocalDate.parse("2023-05-30"));
		MusicalInstrument jaTemNomeInst = new MusicalInstrument("Violao", 150.00, 98, Country.CN);

		Eletronic jaTemId = new Eletronic("Celular", 2200.00, 22, 24, LocalDate.parse("2023-05-30"));
		MusicalInstrument jaTemIdInst = new MusicalInstrument("Guitarra", 320.00, 12, Country.CN);

		System.out.println();

		ProductManager teste = new ProductManager();

		System.out.println("TESTE DE INCLUSAO INICIAL");
		teste.addProduct(p);
		teste.addProduct(m);
		teste.displayProducts();

		System.out.println();
		System.out.println();
		System.out.println("TESTE DE INCLUSAO DE ELEMENTOS TOTALMENTE DIFERENTES");
		teste.addProduct(naoTem);
		teste.addProduct(naoTemInst);
		teste.displayProducts();

		System.out.println();
		System.out.println();
		System.out.println("TENTATIVA DE INCLUSAO ELEMENTOS COM ID E NAME REPETIDOS");
		teste.addProduct(jaTem);
		teste.addProduct(jaTemInst);
		teste.displayProducts();

		System.out.println();
		System.out.println();
		System.out.println("TENTATIVA DE INCLUSAO ELEMENTOS NAME REPETIDO E ID DIFERENTE");
		teste.addProduct(jaTemNome);
		teste.addProduct(jaTemNomeInst);
		teste.displayProducts();
		
		System.out.println();
		System.out.println();
		System.out.println("TENTATIVA DE INCLUSAO ELEMENTOS COM ID REPETIDO E NAME DIFEENTE");
		teste.addProduct(jaTemId);
		teste.addProduct(jaTemIdInst);
		teste.displayProducts();
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO O METODO CHECKTAX");
		System.out.println(m.checkTax());
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO O METODO CHECK GUARANTEE");
		System.out.println(p.checkGuarantee());
		System.out.println(naoTem.checkGuarantee());
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO O METODO FINDPRODUCT");
		System.out.println(teste.findProduct(555));
		System.out.println(teste.findProduct(31));
	
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO UPDATE PRODUCT COM NAME E PRICE NULL");
		teste.updateProduct(35, null, null);
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO UPDATE PRODUCT INCORRETO");
		teste.updateProduct(999, "TESTE UPDATE", 1350.00);
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO UPDATE PRODUCT COM NAME JA EXISTENTE");
		teste.updateProduct(31, "Computer", 1350.00);
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO UPDATE PRODUCT SOMENTE DO NAME");
		teste.updateProduct(31, "Garfo Musical", null);
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO UPDATE PRODUCT SOMENTE DO PRICE");
		teste.updateProduct(31, null, 350000.00);
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO O METODO REMOVE PRODUCT");
		teste.removeProduct(1990);
		teste.removeProduct(31);
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO O METODO WRITE TO FILE");
		FileService fileService = new FileService("C:\\Users\\paulo\\Documents\\Testes_Files");
		fileService.writeToFile(teste);
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO O METODO REMOVE FROM FILE");
		fileService.deleteFromFile(teste);
		fileService.writeToFile(teste);
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO O METODO UPDATE FROM FILE");
		fileService.updateFromFile(teste);
		fileService.writeToFile(teste);
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO O METODO INSERT FROM FILE");
		fileService.insertFromFile(teste);
		fileService.writeToFile(teste);
		teste.displayProducts();
		
		
	}
	
}