package at.cinco.sistema;
import at.cinco.dominio.Cardapio;
import at.cinco.dominio.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedidos {

    static List<String> listaDePedidos = new ArrayList<>();

    public static void novo() throws IOException {
        FileWriter arquivo = new FileWriter("C:\\AT4REMASTERED\\pedido.txt");
        PrintWriter gravador = new PrintWriter(arquivo);
        gravador.println("PEDIDO " + "\n");
        pedido(gravador);
    }

    public static void pedido(PrintWriter gravador){
        Scanner leitor = new Scanner(System.in);

        System.out.println("DESEJA FAZER UM PEDIDO?");

        char opcao = leitor.next().charAt(0);
        while(opcao == 'S' || opcao == 's') {

            Programa.listar();

            System.out.println("Digite o nome do item que deseja adicionar: ");
            leitor.nextLine();
            Item itemAdd = Cardapio.buscarPorNomePratos(leitor.nextLine());
            //Item itemAdd2 = Cardapio.buscarPorNomeBebidas(leitor.nextLine());
            //Item itemAdd3 = Cardapio.buscarPorNomeVinhos(leitor.nextLine());

            System.out.println("Adicionar observacao: ");
            String obs = leitor.nextLine();

            if (!obs.equals("N") && !obs.equals("n")) {
                gravador.println("Nome: " + itemAdd.getNome() + " Preco:" + itemAdd.getPreco() + " Obs: " + obs + "\n");
                //gravador.println("Nome: " + itemAdd2.getNome() + " Preco:" + itemAdd2.getPreco() + " Obs: " + obs);
                //gravador.println("Nome: " + itemAdd3.getNome() + " Preco:" + itemAdd3.getPreco() + " Obs: " + obs);
                System.out.println("Nome: " + itemAdd.getNome() + " Preco:" + itemAdd.getPreco() + " Obs: " + obs);
            } else {
                gravador.println("Nome: " + itemAdd.getNome() + " Preco:" + itemAdd.getPreco() + "\n");
            }
        System.out.println("DESEJA REALIZAR NOVO PEDIDO?");
        opcao = leitor.next().charAt(0);
    }
        gravador.close();
    }



    public static void pedir() throws IOException {

        Scanner leitor = new Scanner(System.in);
        File arquivo = new File("C:\\AT4REMASTERED\\pedido.txt");
        leitor = new Scanner(arquivo);

        while(leitor.hasNext()) {
            listaDePedidos.add(leitor.nextLine());
        }

        FileWriter novo = new FileWriter(arquivo);
        PrintWriter gravador = new PrintWriter(arquivo);

        for(String linha : listaDePedidos) {
                gravador.println(linha);
        }
        pedido(gravador);
        novo.close();
    }

}
