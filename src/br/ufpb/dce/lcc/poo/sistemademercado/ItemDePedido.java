package br.ufpb.dce.lcc.poo.sistemademercado;

public class ItemDePedido {
	private Produto produto;
	private String categoriaProduto;
	private int numeroDeItem, qtdProduto;
	private double valor;
	
	public ItemDePedido (Produto produto, String categoria, int numero, int qtd) {
		this.produto = produto;
		this.categoriaProduto = categoria;
		this.numeroDeItem = numero;
		this.qtdProduto = qtd;
		this.valor = qtd * this.produto.getPreco();
		
	}
	public Produto getProduto() {
		return this.produto;
	}
	
	public int getNumeroDeItem() {
		return numeroDeItem;
	}
	public void setNumeroDeItem(int numeroDeItem) {
		this.numeroDeItem = numeroDeItem;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public String getCategoria() {
		return categoriaProduto;
	}
	public void setCategoria(String categoria) {
		this.categoriaProduto = categoria;
	}
	public int getQtdProduto() {
		return qtdProduto;
	}
	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valorParcial) {
		this.valor = valorParcial;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((categoriaProduto == null) ? 0 : categoriaProduto.hashCode());
		result = prime * result + numeroDeItem;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + qtdProduto;
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDePedido other = (ItemDePedido) obj;
		if (categoriaProduto == null) {
			if (other.categoriaProduto != null)
				return false;
		} else if (!categoriaProduto.equals(other.categoriaProduto))
			return false;
		if (numeroDeItem != other.numeroDeItem)
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (qtdProduto != other.qtdProduto)
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	

}
