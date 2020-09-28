package at.cinco.dominio;

public class Item {

	private String nome;
	private double preco;
	
	//Construtor vazio
//	public Item() {}
	
	//Construtor com parametros
	public Item(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public Item(String nome, String preco) {
		this.nome = nome;
		this.preco = Double.parseDouble(preco);
	}

	public Item() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return nome + ";" + preco;
	}
	
	
}
