package at.cinco.dominio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cardapio {

	private static List<Item> listaDePratos;
	private static List<Item> listaDeBebidas;
	private static List<Item> listaDeVinhos;

	public static String arquivoPratos = "C:\\AT4REMASTERED\\pratos.txt";
	public static String arquivoBebidas = "C:\\AT4REMASTERED\\bebidas-tabuladas.txt";
	public static String arquivoVinhos = "C:\\AT4REMASTERED\\vinhos-tabulados.txt";

	static {
		listaDePratos = new ArrayList<Item>();
		listaDeBebidas = new ArrayList<Item>();
		listaDeVinhos = new ArrayList<Item>();
	}

	public static List<Item> carregarListaDePratos(String arquivoPratos) {

		try {
			File arquivo = new File(Cardapio.arquivoPratos);
			Scanner leitor = new Scanner(new FileInputStream(arquivo),"UTF-8");
			leitor.nextLine();

			while(leitor.hasNextLine()) {
				String linha = leitor.nextLine();
				String[] partes = linha.split(";");
				Item pratos = new Item();
				pratos.setNome(partes[0]);
				pratos.setPreco(Double.parseDouble(partes[1]));
				listaDePratos.add(pratos);
				int i = 1;
				for (Item item : listaDePratos) {
					System.out.println((i++) + " " + item);
				}
			}
			leitor.close();
			} catch (FileNotFoundException e) {
				System.out.println("Erro na leitura do arquivo!");
				e.printStackTrace();}
			return listaDePratos;
		}

	public static List<Item> carregarListaDeBebidas(String arquivoBebidas) {
		

		try {
			File arquivo = new File(Cardapio.arquivoBebidas);
			Scanner leitor = new Scanner(new FileInputStream(arquivo), "UTF-8");
			leitor.nextLine();
			
			while(leitor.hasNextLine()) {
				String linha = leitor.nextLine();
				String[] partes = linha.split("\t");
				Item bebidas = new Item();
				bebidas.setPreco(Double.parseDouble(partes[0].replaceAll(",", ".")));
				bebidas.setNome(partes[1]);
				listaDeBebidas.add(bebidas);
			}

			int i = 1;
			for (Item item : listaDeBebidas) {
				System.out.println((i++) + " " + item);
			}
			leitor.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro na leitura do arquivo!");
			e.printStackTrace();}
	return listaDeBebidas;
	}
	
	public static List<Item> carregarListaDeVinhos(String arquivoVinhos) {

		try {
		File arquivo = new File(Cardapio.arquivoVinhos);
		Scanner leitor = new Scanner(new FileInputStream(arquivo), "UTF-8");
		leitor.nextLine();
		
		while(leitor.hasNext()) {
			String linha = leitor.nextLine();
			String[] partes = linha.split("\t");
			Item vinho = new Item();
			vinho.setPreco(Double.parseDouble(partes[0]));
			vinho.setNome(partes[1]);
			listaDeVinhos.add(vinho);
		}
			int i = 1;
			for (Item item : listaDeVinhos) {
				System.out.println((i++) + " " + item);
			}
		leitor.close();
		
	} catch (FileNotFoundException e) {
		System.out.println("Erro na leitura do arquivo!");
		e.printStackTrace();}
	return listaDeVinhos;
	}
	
	public static void addPrato(Item item) {
		listaDePratos.add(item);
		incluirPrato(item);
	}
	
	public static void incluirPrato(Item item) {
		try {
			Scanner leitor = new Scanner(System.in);
			FileWriter arquivo = new FileWriter(arquivoPratos, true);
			PrintWriter gravador = new PrintWriter(arquivo);
			System.out.println("\nInforme o o item que deseja adicionar: ");
			String nome = leitor.nextLine();
			System.out.println("Informe o preço: ");
			String price = leitor.nextLine();
			gravador.print("\r" + nome + ";" + price);
			gravador.close();
			arquivo.close();

		} catch (IOException e) {
			System.out.println("Erro na gravação do arquivo!");
			e.printStackTrace();}
	}
	
	public static void addBebida(Item item) {
		listaDeBebidas.add(item);
		incluirBebida(item);
	}
	
		public static void incluirBebida(Item item) {
			try {
				Scanner leitor = new Scanner(System.in);
				FileWriter arquivo = new FileWriter(arquivoBebidas, true);
				PrintWriter gravador = new PrintWriter(arquivo);
				System.out.println("\nInforme o o item que deseja adicionar: ");
				String nome = leitor.nextLine();
				System.out.println("Informe o preço: ");
				String price = leitor.nextLine();
				gravador.print("\n" + price + "\t" + nome);
				gravador.close();
				arquivo.close();

			} catch (IOException e) {
				System.out.println("Erro na gravação do arquivo!");
				e.printStackTrace();}
		}
		
		public static void addVinho(Item item) {
			listaDeVinhos.add(item);
			incluirVinho(item);
		}
		
		public static void incluirVinho(Item item) {
			try {
				Scanner leitor = new Scanner(System.in);
				FileWriter arquivo = new FileWriter(arquivoVinhos, true);
				PrintWriter gravador = new PrintWriter(arquivo);
				System.out.println("\nInforme o o item que deseja adicionar: ");
				String nome = leitor.nextLine();
				System.out.println("Informe o preço: ");
				String price = leitor.nextLine();
				gravador.print("\n" + price + "\t" + nome);
				gravador.close();
				arquivo.close();
			} catch (IOException e) {
				System.out.println("Erro na gravação do arquivo!");
				e.printStackTrace();}
		 }

		public static void removePrato(Item item) {
			listaDePratos.remove(item);
			try {
				excluirPrato(item);
			} catch (IOException e) {
				e.printStackTrace();}
		}

	public static void excluirPrato(Item item) throws IOException {
		Scanner leitor = new Scanner(System.in);
		System.out.println("\nInforme o nome do item que deseja remover: ");
		String nome = leitor.nextLine();
		Item itemRemover = buscarPorNomePratos(nome);
		listaDePratos.remove(itemRemover);
	}

		public static void gravarListaAtualizadaPratos(Item prato) {
			try {
				FileWriter arquivo = new FileWriter(arquivoPratos, true);
				PrintWriter gravador = new PrintWriter(arquivoPratos);
				for (Item item : listaDePratos) {
					gravador.println(item);}
				gravador.close();
				arquivo.close();
			} catch (IOException e) {
				System.out.println("Erro na gravação do arquivo!");
				e.printStackTrace();}
		}
		
		public static void excluirBebida(Item item) {
			listaDeBebidas.remove(item);
			gravarListaAtualizadaBebidas(listaDeBebidas);
		}

		public static void gravarListaAtualizadaBebidas(List<Item> listaDeItem2) {
			try {
				FileWriter arquivo = new FileWriter(arquivoBebidas, true);
				PrintWriter gravador = new PrintWriter(arquivoBebidas);
				for (Item item : listaDeBebidas) {
					gravador.println(item);
					}
				gravador.close();
				arquivo.close();
				
			} catch (IOException e) {
				System.out.println("Erro na gravação do arquivo!");
				e.printStackTrace();}
		}
		
		public static void excluirVinho(Item item) {
			listaDePratos.remove(item);
			gravarListaAtualizadaVinhos(listaDePratos);
		}

		public static void gravarListaAtualizadaVinhos(List<Item> listaDeItem3) {
			try {
				FileWriter arquivo = new FileWriter(arquivoVinhos, true);
				PrintWriter gravador = new PrintWriter(arquivoVinhos);
				for (Item item : listaDeVinhos) {
					gravador.println(item);}
				gravador.close();
				arquivo.close();
				
			} catch (IOException e) {
				System.out.println("Erro na gravação do arquivo!");
				e.printStackTrace();}
		}
		
		public static Item buscarPorNomePratos(String nome) {
			Item pratoRetornado = null;
			
			for (Item item : listaDePratos) {
				if (item.getNome().contains(nome)){
					pratoRetornado = item;
					break;}
			}
			return pratoRetornado;
		}
		
		public static Item buscarPorNomeBebidas(String nome) {
			Item bebidaRetornada = null;
			
			for (Item item : listaDeBebidas) {
				if (item.getNome().contains(nome)){
					bebidaRetornada = item;
					break;}
			}
			return bebidaRetornada;
		}
		
		public static Item buscarPorNomeVinhos(String nome) {
			Item vinhoRetornado = null;
			
			for (Item item : listaDePratos) {
				if (item.getNome().contains(nome)){
					vinhoRetornado = item;
					break;}
			}
			return vinhoRetornado;
		}

}
	
	
	
	
