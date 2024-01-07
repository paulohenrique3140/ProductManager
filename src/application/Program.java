package application;

import java.time.LocalDate;

import model.entities.Eletronic;
import model.entities.MusicalInstrument;
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

		Eletronic jaTemNome = new Eletronic("Computer", 3200.00, 102, 24, LocalDate.parse("2023-05-30"));
		MusicalInstrument jaTemNomeInst = new MusicalInstrument("Violao", 150.00, 98, Country.CN);

		Eletronic jaTemId = new Eletronic("Celular", 2200.00, 22, 24, LocalDate.parse("2023-05-30"));
		MusicalInstrument jaTemIdInst = new MusicalInstrument("Guitarra", 320.00, 12, Country.CN);

		System.out.println();

		ProductManager teste = new ProductManager();

		System.out.println("TESTE DE INCLUSAO INICIAL");
		teste.addProduct(p);
		teste.addProduct(m);
		System.out.println(teste.displayProducts());

		System.out.println();
		System.out.println();
		System.out.println("TESTE DE INCLUSAO DE ELEMENTOS TOTALMENTE DIFERENTES");
		teste.addProduct(naoTem);
		teste.addProduct(naoTemInst);
		System.out.println(teste.displayProducts());

		System.out.println();
		System.out.println();
		System.out.println("TENTATIVA DE INCLUSAO ELEMENTOS COM ID E NAME REPETIDOS");
		teste.addProduct(jaTem);
		teste.addProduct(jaTemInst);
		System.out.println(teste.displayProducts());

		System.out.println();
		System.out.println();
		System.out.println("TENTATIVA DE INCLUSAO ELEMENTOS NAME REPETIDO E ID DIFERENTE");
		teste.addProduct(jaTemNome);
		teste.addProduct(jaTemNomeInst);
		System.out.println(teste.displayProducts());
		
		System.out.println();
		System.out.println();
		System.out.println("TENTATIVA DE INCLUSAO ELEMENTOS COM ID REPETIDO E NAME DIFEENTE");
		teste.addProduct(jaTemId);
		teste.addProduct(jaTemIdInst);
		System.out.println(teste.displayProducts());
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO O METODO CHECKTAX");
		System.out.println(m.checkTax());
		
		System.out.println();
		System.out.println();
		System.out.println("TESTANDO O METODO FINDPRODUCT");
		System.out.println(teste.findProduct(555));
		System.out.println(teste.findProduct(31));
	}
}