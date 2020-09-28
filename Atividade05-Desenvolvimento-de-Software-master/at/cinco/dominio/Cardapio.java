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
		//listaDePratos = carregarListaDePratos(arquivoPratos);

		listaDeBebidas = new ArrayList<Item>();
		//listaDeBebidas = carregarListaDeBebidas(arquivoBebidas);

		listaDeVinhos = new ArrayList<Item>();
		//listaDeVinhos = carregarListaDeVinhos(arquivoVinhos);
	}

	//Listar itens
	public static List<Item> carregarListaDePratos(String arquivoPratos) {
		
		listaDePratos.clear();

		try {
			File arquivo = new File(Cardapio.arquivoPratos);
			Scanner leitor = new Scanner(new FileInputStream(arquivo),"UTF-8");
			leitor.nextLine();

			while(leitor.hasNextLine()) {
				String linha = leitor.nextLine();
				String[] partes = linha.split(";");
				Item pratos = new Item();
				pratos.setNome(partes[0]);
				//pratos.setPreco(Double.parseDouble(partes[0]));
				listaDePratos.add(pratos);
			}
			leitor.close();
			System.out.println(listaDePratos);

		} catch (FileNotFoundException e) {
			System.out.println("Erro na leitura do arquivo!");
			e.printStackTrace();
		}
		
		return listaDePratos;
		}

	public static List<Item> carregarListaDeBebidas(String arquivoBebidas) {
		
		List<Item> itensBebidas = new ArrayList<>();
		
		try {
			File arquivo = new File(Cardapio.arquivoBebidas);
			Scanner leitor = new Scanner(new FileInputStream(Cardapio.arquivoBebidas), "UTF-8");
			leitor.nextLine();
			
			while(leitor.hasNext()) {
				String linha = leitor.nextLine();
				String[] partes = linha.split(";");
				Item item = new Item(partes[0], partes[1]);
				itensBebidas.add(item);
			}
			leitor.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Erro na leitura do arquivo!");
			e.printStackTrace();
		}
	return itensBebidas;
	}
	
	public static List<Item> carregarListaDeVinhos(String arquivoVinhos) {
	
		List<Item> itensVinhos = new ArrayList<>();
	
		try {
		File arquivo = new File(Cardapio.arquivoVinhos);
		Scanner leitor = new Scanner(new FileInputStream(Cardapio.arquivoVinhos), "UTF-8");
		leitor.nextLine();
		
		while(leitor.hasNext()) {
			String linha = leitor.nextLine();
			String[] partes = linha.split(";");
			Item item = new Item(partes[0], partes[1]);
			itensVinhos.add(item);
		}
		leitor.close();
		
	} catch (FileNotFoundException e) {
		System.out.println("Erro na leitura do arquivo!");
		e.printStackTrace();
	}
	return itensVinhos;
	}
	
	//Incluir itens
	public static void addPrato(Item item) {
		listaDePratos.add(item);
		incluirPrato(item);
	}
	
	public static void incluirPrato(Item item) {
		try {
			FileWriter arquivo = new FileWriter(arquivoPratos, true);
			PrintWriter gravador = new PrintWriter(arquivoPratos);
			gravador.println(item);
			gravador.close();
			arquivo.close();
			
		} catch (IOException e) {
			System.out.println("Erro na gravação do arquivo!");
			e.printStackTrace();
		}
	}
	
	public static void addBebida(Item item) {
		listaDeBebidas.add(item);
		incluirBebida(item);
	}
	
		public static void incluirBebida(Item item) {
			try {
				FileWriter arquivo = new FileWriter(arquivoBebidas, true);
				PrintWriter gravador = new PrintWriter(arquivoBebidas);
				gravador.println(item);
				gravador.close();
				arquivo.close();
				
			} catch (IOException e) {
				System.out.println("Erro na gravação do arquivo!");
				e.printStackTrace();
			}	
		}
		
		public static void addVinho(Item item) {
			listaDeVinhos.add(item);
			incluirVinho(item);
		}
		
		public static void incluirVinho(Item item) {
			try {
				FileWriter arquivo = new FileWriter(arquivoVinhos, true);
				PrintWriter gravador = new PrintWriter(arquivoVinhos);
				gravador.println(item);
				gravador.close();
				arquivo.close();
				
			} catch (IOException e) {
				System.out.println("Erro na gravação do arquivo!");
				e.printStackTrace();
			}
		 }
		
		//Excluir itens e atualizar listas
		public static void excluirPrato(Item item) {
			listaDePratos.remove(item);
			gravarListaAtualizadaPratos(listaDePratos);
		}
		public static void gravarListaAtualizadaPratos(List<Item> listaDeItem1) {
			try {
				FileWriter arquivo = new FileWriter(arquivoPratos, true);
				PrintWriter gravador = new PrintWriter(arquivoPratos);
				for (Item item : listaDePratos) {
					gravador.println(item);
						
					}
				gravador.close();
				arquivo.close();
				
			} catch (IOException e) {
				System.out.println("Erro na gravação do arquivo!");
				e.printStackTrace();
			}
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
				e.printStackTrace();
			}
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
					gravador.println(item);
						
					}
				gravador.close();
				arquivo.close();
				
			} catch (IOException e) {
				System.out.println("Erro na gravação do arquivo!");
				e.printStackTrace();
			}
		}
		
		//Buscar por nome
		public static Item buscarPorNomePratos(String nome) {
			Item pratoRetornado = null;
			
			for (Item item : listaDePratos) {
				if (item.getNome().contains(nome)){
					pratoRetornado = item;
					break;
				}
			}
			
			return pratoRetornado;
		}
		
		public static Item buscarPorNomeBebidas(String nome) {
			Item bebidaRetornada = null;
			
			for (Item item : listaDeBebidas) {
				if (item.getNome().contains(nome)){
					bebidaRetornada = item;
					break;
				}
			}
			
			return bebidaRetornada;
		}
		
		public static Item buscarPorNomeVinhos(String nome) {
			Item vinhoRetornado = null;
			
			for (Item item : listaDePratos) {
				if (item.getNome().contains(nome)){
					vinhoRetornado = item;
					break;
				}
			}
			
			return vinhoRetornado;
		}

}	
	
	
	
	
	
	