package files;

public class Rascunho {

	public static void main(String[] args) {
		
		/* ################## 01 ######################
		 *  ### TRECHO DE CODIGO PARA BUFFERED READER ###
		 * 
		 * String path = "C:\\Users\\paulo\\Documents\\Testes_Files\\teste.txt";
		
		
		 *
		 * try(BufferedReader br = new BufferedReader(new FileReader(path))) {
		 
			
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		*
		*/
		
		/*
		 *  ############ 02 ##############
			### TRECHO DE CODIGO PARA BUFFERED WRITER (SUBSTITUIR O QUE TEM NO ARQUIVO) ###
		
		String path = "C:\\Users\\paulo\\Documents\\Testes_Files\\teste.txt";
		
		String[] lines = new String[] { "How are you?" , "I love you"};
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		*/
		
		/*
		 *  ######### 03 #################
			### TRECHO DE CODIGO PARA BUFFERED WRITER (ACRESCENTAR AO ARQUIVO JÁ EXISTENTE) ###
		
		String path = "C:\\Users\\paulo\\Documents\\Testes_Files\\teste.txt";
		
		String[] lines = new String[] { "How are you?" , "I love you"};
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		*/
		
		/*
		 *  ########### 04 ###############
		 *  ### TRECHO DE CODIGO PARA LISTAR PASTAS DE UM CAMINHO, LISTAR ARQUIVOS E CRIAR PASTAS ###
		 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("Folders:");
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		File[] files = path.listFiles(File::isFile);
		System.out.println("FILES:");
		for (File file : files) {
			System.out.println(file);
		}
		
		boolean success = new File(strPath + "\\testeCriacao").mkdir();
		System.out.println("Directory created successfully: " + success);
		
		sc.close();
		*/
		
		/*
		 * ################## 05 ##########################
		 * ### TRECHO DE CÓDIGO PARA MOSTRAR NA TELA O CAMINHO INSERIDO, 
		 * O CAMINHO DA PASTA PAI E O NOME DA PASTA ATUAL ###
		 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		System.out.println("getPath: " + path.getPath());
		System.out.println("getParent: " + path.getParent());
		System.out.println("getName: " + path.getName());
		
		sc.close();
		*/
		
		/*
		 * ################## EXERCÍCIO PROPOSTO  ##########################
		 * 
		 * Fazer um programa para ler o caminho de um arquivo .csv
		   contendo os dados de itens vendidos. Cada item possui um
		   nome, preço unitário e quantidade, separados por vírgula. Você
		   deve gerar um novo arquivo chamado "summary.csv", localizado
		   em uma subpasta chamada "out" a partir da pasta original do
		   arquivo de origem, contendo apenas o nome e o valor total para
		   aquele item (preço unitário multiplicado pela quantidade),
		   conforme exemplo.
		
		*** RESOLUÇÃO ***
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<ProductTest> list = new ArrayList<>();
		
		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine(); // instancia uma String com o caminho do usuario
		
		File sourceFile = new File(sourceFileStr); // instancia um File com o caminho sourceFileStr
		String sourceFolderStr = sourceFile.getParent(); // instancia uma String com o parent do sourceFileStr
		
		boolean success = new File(sourceFolderStr + "\\out").mkdir(); // cria uma pasta out no pai do caminho digitado pelo usuario
		
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv"; // instancia uma str com o nome do arq a ser criado em outr
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) { // instancia um br para ler o arquivo do usuario
			
			String itemCsv = br.readLine(); // instancia uma String para armazenar as linhas de leitura (leitor)
			while (itemCsv != null) { // executa o bloco ate o final do arquivo
				
				String[] fields = itemCsv.split(","); // cria um vetor para 'dividir' os dados do arq separando os a cada virgula
				String name = fields[0]; // instancia uma String com o primeiro termo antes da virgula
				double price = Double.parseDouble(fields[1]); // instancia um double com o termo depois da primeira virgula
				int quantity = Integer.parseInt(fields[2]); // instancia um int com o termo apos a segunda virgula
				
				list.add(new ProductTest(name, price, quantity)); // instancia um productTest com os dados da leitura
				
				itemCsv = br.readLine(); // ordena que o "leitor" va para a proxima linha
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) { // instancia um bw para o arquivo csv criado em out
				
				for (ProductTest item : list) { // percorre a lista lida do arquivo do usuario e captura apenas o nome e o valor total
					bw.write(item.getName() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}
				
				System.out.println(targetFileStr + "CREATED");
				
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
			
		} catch (IOException e) {
			
		} 
		sc.close();
		*/
		
	}

}
