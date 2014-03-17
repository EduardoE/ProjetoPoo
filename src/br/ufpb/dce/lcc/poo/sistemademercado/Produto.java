package br.ufpb.dce.lcc.poo.sistemademercado;

public class Produto {
	private String nome;
	private int codigo;
	private double preco;
	
	public Produto(String nome, int codigo, double preco){
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
	}
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String mostrarPreco () {
		 return "Preco = "+this.preco;
	}
}
