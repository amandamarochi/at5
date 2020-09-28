package at.cinco.sistema;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import at.cinco.dominio.Cardapio;
import at.cinco.dominio.Item;

public class Programa {

	public static void main (String[] args) throws IOException {

		int retorno = 0;
		Scanner leitor = new Scanner(System.in);

		do {
			System.out.println("\n\t----CARDÁPIO----\n");
			System.out.println("1 - Novo pedido");
			System.out.println("2 - Listar");
			System.out.println("3 - Modificar");
			System.out.println("0 - Sair");
			retorno = leitor.nextInt();
			switch(retorno) {
				case 1:
					Pedidos.novoPedido();
					break;
				case 2:
					listar();
					break;
				case 3:
					modificar();
			}
		} while(retorno != 0);

		leitor.close();
	}

	private static void modificar(){
		Item item = new Item(null, 0);

		Scanner leitor = new Scanner(System.in);

		int retorno;
		do {
			System.out.println("1 - Adicionar item a pratos");
			System.out.println("2 - Adicionar item a bebidas");
			System.out.println("3 - Adicionar item aos vinhos");
			System.out.println("4 - Atualizar item de pratos");
			System.out.println("5 - Atualizar item de bebidas");
			System.out.println("6 - Atualizar item de vinhos");
			System.out.println("7 - Remover item de pratos");
			System.out.println("8 - Remover item de bebidas");
			System.out.println("9 - Remover item de vinhos");
			System.out.println("0 - Sair");

			retorno = leitor.nextInt();
			switch(retorno) {
				case 1:
					Cardapio.incluirPrato(item);
					break;
				case 2:
					Cardapio.incluirBebida(item);
					break;
				case 3:
					Cardapio.incluirVinho(item);
					break;
				case 4:
					Cardapio.gravarListaAtualizadaPratos(null);
					break;
				case 5:
					Cardapio.gravarListaAtualizadaBebidas(null);
					break;
				case 6:
					Cardapio.gravarListaAtualizadaVinhos(null);
					break;
				case 7:
					Cardapio.excluirPrato(item);
					break;
				case 8:
					Cardapio.excluirBebida(item);
					break;
				case 9:
					Cardapio.excluirVinho(item);
			}
		} while(retorno != 0);

	}

	public static void listar(){
		Item item = new Item(null, 0);

		Scanner leitor = new Scanner(System.in);
		System.out.println("1 - Para pratos");
		System.out.println("2 - Para bebidas");
		System.out.println("3 - Para vinhos");
		switch(leitor.nextInt()) {
			case 1:
				List<Item> lista1 = Cardapio.carregarListaDePratos();
				System.out.println("--------------------");
				System.out.println("Tamanho da lista: " +lista1.size());

				for (Item itensPratos : lista1) {
					System.out.println(item.getNome() + ";" + " "  + item.getPreco());
				}
				break;
			case 2:
				List<Item> lista2 = Cardapio.carregarListaDeBebidas();
				System.out.println("--------------------");
				System.out.println("Tamanho da lista: " +lista2.size());

				for (Item itensBebidas : lista2) {
					System.out.println(item.getNome() + ";" + " "  + item.getPreco());
				}
				break;
			case 3:
				List<Item> lista3 = Cardapio.carregarListaDeVinhos();
				System.out.println("--------------------");
				System.out.println("Tamanho da lista: " +lista3.size());

				for (Item itensVinhos : lista3) {
					System.out.println(item.getNome() + ";" + " "  + item.getPreco());

				}
		}

	}
 }