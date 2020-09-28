//Fazer a parte de processamento de pedidos 

package at.cinco.sistema;

import at.cinco.dominio.Cardapio;
import at.cinco.dominio.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedidos {

    static int codigoPedido = 1;
    static List<String> listaDePedidos = new ArrayList<>();

    public static void novoPedido() throws IOException {
        FileWriter arquivo = new FileWriter("C:\\AT4REMASTERED\\pedido " + codigoPedido + ".txt");
        PrintWriter gravador = new PrintWriter(arquivo);
        gravador.println("PEDIDO " + codigoPedido + "\n");
        pedido(gravador);
        codigoPedido++;
    }

    public static void pedido(PrintWriter gravador) throws FileNotFoundException {
        Scanner leitor = new Scanner(System.in);
        int cod;

        Programa.listar();

        System.out.println("\nInforme o número do item que deseja adicionar: ");

        cod = leitor.nextInt();


        if (cod == 1) {
            System.out.println("Digite o nome do item que deseja adicionar: ");
            Item itemAdd = Cardapio.buscarPorNomePratos(leitor.nextLine());

            System.out.println("Adicionar observação: (S/N)");
            String obs = leitor.nextLine();

            if (!obs.equals("N") && !obs.equals("n")) {
                gravador.println(itemAdd.getPreco() + itemAdd.getNome() + obs);
                System.out.println(itemAdd.getNome());
            } else {
                gravador.println(itemAdd.getPreco() + itemAdd.getNome());
            }
        } else if(cod == 2) {
            System.out.println("Digite o nome do item que deseja adicionar: ");
            Item itemAdd = Cardapio.buscarPorNomeBebidas(leitor.nextLine());

            System.out.println("Adicionar observação: (S/N)");
            String obs = leitor.nextLine();

            if (!obs.equals("N") && !obs.equals("n")) {
                gravador.println(itemAdd.getPreco() + itemAdd.getNome() + obs);
                System.out.println(itemAdd.getNome());
            } else {
                gravador.println(itemAdd.getPreco() + itemAdd.getNome());
            }
        }else {
            System.out.println("Digite o nome do item que deseja adicionar: ");
            Item itemAdd = Cardapio.buscarPorNomeVinhos(leitor.nextLine());

            System.out.println("Adicionar observação: (S/N)");
            String obs = leitor.nextLine();

            if (!obs.equals("N") && !obs.equals("n")) {
                gravador.println(itemAdd.getPreco() + itemAdd.getNome() + obs);
                System.out.println(itemAdd.getNome());
            } else {
                gravador.println(itemAdd.getPreco() + itemAdd.getNome());
            }
        }

        gravador.close();
    }

    public static void pedidoExistente() throws IOException {

        listaDePedidos.clear();
        Scanner leitor = new Scanner(System.in);

        System.out.println("\nInforme o codigo do pedido do cliente: ");
        leitor.nextInt();
        File arquivo = new File("C:\\AT4REMASTERED\\pedido " + codigoPedido + ".txt");
        leitor = new Scanner(arquivo);
        double total = 0;

        while(leitor.hasNext()) {
            listaDePedidos.add(leitor.nextLine());
        }

        FileWriter arquivoNovo = new FileWriter(arquivo);
        PrintWriter gravador = new PrintWriter(arquivo);

        int i = 0;
        for(String linha : listaDePedidos) {

            if(i == listaDePedidos.size() - 2) {

            }else if(linha.contains("TOTAL")) {
                String [] partes = linha.split("\t");
                total = Double.parseDouble(partes[1]);
            }else {
                gravador.println(linha);
            }
            i++;
        }

        pedido(gravador);

        arquivoNovo.close();
    }

}
