package application;

import java.time.LocalDate;
import java.util.Set;

import model.entities.Eletronic;
import model.entities.MusicalInstrument;
import model.entities.Product;
import model.entities.ProductManager;
import model.entities.enums.Country;

public class Program {
	public static void main(String[] args) {

		Eletronic p = new Eletronic("Computer", 1500.00, 22, 36, LocalDate.parse("2021-01-07"));
		MusicalInstrument m = new MusicalInstrument("Piano", 15000.00, 31, Country.PT);

		Eletronic naoTem = new Eletronic("Mouse", 250.00, 35, 12, LocalDate.parse("2022-02-08"));
		Eletronic jaTem = new Eletronic("Computer", 1500.00, 22, 36, LocalDate.parse("2021-01-07"));

		MusicalInstrument naoTemInst = new MusicalInstrument("Violao", 900.00, 99, Country.BR);
		MusicalInstrument jaTemInst = new MusicalInstrument("Piano", 15000.00, 31, Country.PT);

		Eletronic jaTemNome = new Eletronic("Computer", 3200.00, 99, 24, LocalDate.parse("2023-05-30"));
		MusicalInstrument jaTemNomeInst = new MusicalInstrument("Violao", 150.00, 98, Country.CN);

		Eletronic jaTemId = new Eletronic("Celular", 2200.00, 22, 24, LocalDate.parse("2023-05-30"));
		MusicalInstrument jaTemIdInst = new MusicalInstrument("Guitarra", 320.00, 12, Country.CN);

		System.out.println();

		ProductManager teste = new ProductManager();

		// inclusao inicial
		teste.addProduct(p);
		teste.addProduct(m);
		System.out.println("TESTE DE INCLUSAO INICIAL");
		System.out.println(teste.displayProducts());

		// add elementos diferentes
		teste.addProduct(naoTem);
		teste.addProduct(naoTemInst);
		System.out.println();
		System.out.println();
		System.out.println("TESTE DE INCLUSAO DE ELEMENTOS TOTALMENTE DIFERENTES");
		System.out.println(teste.displayProducts());

		// add id e name repetidos
		teste.addProduct(jaTem);
		teste.addProduct(jaTemInst);
		System.out.println();
		System.out.println();
		System.out.println("TENTATIVA DE INCLUSAO ELEMENTOS COM ID E NAME REPETIDOS");
		System.out.println(teste.displayProducts());

		// add apenas nome igual e id diferente
		if (hasName(teste.getStock(), jaTemNome)) {
			System.out.println("Name already exists");
		} else {
			teste.addProduct(jaTemNome);
		}
		
		if (hasName(teste.getStock(), jaTemNomeInst)) {
			System.out.println("Name already exists");
		} else {
			teste.addProduct(jaTemNomeInst);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("TENTATIVA DE INCLUSAO ELEMENTOS NAME REPETIDO E ID DIFERENTE");
		System.out.println(teste.displayProducts());
		
		
		// add apenas id igual e name diferente
		teste.addProduct(jaTemId);
		teste.addProduct(jaTemIdInst);
		System.out.println();
		System.out.println();
		System.out.println("TENTATIVA DE INCLUSAO ELEMENTOS COM NOME REPETIDO E ID DIFEENTE");
		System.out.println(teste.displayProducts());

		// add apenas id igual e name diferente
		//

	}
	
	public static boolean hasName(Set<Product> stock, Product product) {
		Product list = stock.stream().filter(x -> x.getName().equals(product.getName())).findFirst().orElse(null);
		return list != null;
	}
}