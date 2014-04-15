package br.ufpb.dce.lcc.poo.sistemademercado;

import java.util.LinkedList;
import java.util.List;

public class GerenteDeProduto {
	private List <Produto> produtos;
	
	public GerenteDeProduto(){
		this.produtos = new LinkedList <Produto>();
	}

	public void cadastra(Produto produto){
		for (Produto p: this.produtos) {
			if (p.getCodigo() == produto.getCodigo()) 
				throw new ExcecaoSistemaDeMercado("O Produto já existe!");
		}
		produtos.add(produto);
		
	}

	public Produto pesquisaPorNome(String nome) {
		for(Produto p: this.produtos){
			if(p.getNome().equals(nome)){
				return p;
			}
		}
		
		throw new ExcecaoSistemaDeMercado ("Produto não existe!");
	}

	public void remove(int codigo){
		boolean remove = false;
		for(Produto p: this.produtos){
			if(p.getCodigo() == codigo){
				this.produtos.remove(p);
				remove = true;
				break;
			}
		}
		if(!remove){
			throw new ExcecaoSistemaDeMercado("Produto não existe!s");
		}
	}

	public Produto pesquisaPorCodigo(int codigo){		
		for(Produto p: this.produtos){
			if(p.getCodigo() == (codigo)){
				return p;
			}
		}
		
		throw new ExcecaoSistemaDeMercado("O produto não encontrado");
	}

	public void altera (Produto novo) {
		for (Produto p : this.produtos){
			if (p.getCodigo() == novo.getCodigo()) {
				p.setNome(novo.getNome());
				p.setPreco(novo.getPreco());
			}
		}
		
	}
}





