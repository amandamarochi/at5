package at.cinco.sistema;
import java.io.IOException;
import java.util.Scanner;
import at.cinco.dominio.Cardapio;
import at.cinco.dominio.Item;

public class Programa {

	public static void main (String[] args) throws IOException {
		int var = 0;
		Scanner leitor = new Scanner(System.in);

		do {
			System.out.println("CARDÁPIO");
			System.out.println("1 - Novo pedido");
			System.out.println("2 - Listar");
			System.out.println("3 - Modificar");
			System.out.println("0 - Sair");
			var = leitor.nextInt();
			switch(var) {
				case 1:
					Pedidos.novo();
					break;
				case 2:
					listar();
					break;
				case 3:
					modificar();
			}
		} while(var != 0);
		leitor.close();
	}

	private static void modificar(){
		Item item = new Item(null, 0);
		Scanner leitor = new Scanner(System.in);
		int retorno;

			System.out.println("1 - Adicionar pratos");
			System.out.println("2 - Adicionar bebidas");
			System.out.println("3 - Adicionar vinhos");
			System.out.println("4 - Atualizar pratos");
			System.out.println("5 - Atualizar bebidas");
			System.out.println("6 - Atualizar vinhos");
			System.out.println("7 - Remover pratos");
			System.out.println("8 - Remover bebidas");
			System.out.println("9 - Remover vinhos");
			System.out.println("0 - Sair");

			retorno = leitor.nextInt();
			switch(retorno) {
				case 1:
					Cardapio.addPrato(item);
					break;
				case 2:
					Cardapio.addBebida(item);
					break;
				case 3:
					Cardapio.addVinho(item);
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
					Cardapio.removePrato(item);
					break;
				case 8:
					Cardapio.excluirBebida(item);
					break;
				case 9:
					Cardapio.excluirVinho(item);
			}
	}

	public static void listar(){

		Scanner leitor = new Scanner(System.in);
		System.out.println("1 - Pratos");
		System.out.println("2 - Bebidas");
		System.out.println("3 - Vinhos");
		switch(leitor.nextInt()) {
			case 1:
				Cardapio.carregarListaDePratos(Cardapio.arquivoPratos);
				break;
			case 2:
				Cardapio.carregarListaDeBebidas(Cardapio.arquivoBebidas);
				break;
			case 3:
				Cardapio.carregarListaDeVinhos(Cardapio.arquivoVinhos);
			}
	}
}
