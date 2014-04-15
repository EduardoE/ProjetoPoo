package br.ufpb.dce.lcc.poo.sistemademercado;

import java.util.LinkedList;
import java.util.List;

public class GerenteDeFornecedor {
	private List <Fornecedor> fornecedores;
	
	public GerenteDeFornecedor(){
		this.fornecedores = new LinkedList<Fornecedor>();
	}

	public void cadastra(Fornecedor fornecedor) {
		for (Fornecedor f: this.fornecedores) {
			if (f.getCnpj().equals(fornecedor.getCnpj())) {
				throw new ExcecaoSistemaDeMercado ("Fornecedor já existe!");
			}
		}
		fornecedores.add(fornecedor);
		
	}

	public Fornecedor pesquisaPorNome(String nome) {
		for(Fornecedor f: this.fornecedores){
			if(f.getNome().equals(nome)){
				return f;
			}
		}
		throw new ExcecaoSistemaDeMercado ("Fornecedor nao existe!");
	}
	public Fornecedor pesquisaPorCnpj (String cnpj) {
		for(Fornecedor f: this.fornecedores){
			if(f.getCnpj().equals(cnpj)){
				return f;
			}
		}
		throw new ExcecaoSistemaDeMercado ("Fornecedor nao existe!");

	}

	public void removeFornecedorPorCnpj (String cnpj) {
		boolean remove = false;
		for(Fornecedor f: this.fornecedores){
			if(f.getCnpj().equals(cnpj)){
				this.fornecedores.remove(f);
				remove = true;
				break;
			}
		}if(!remove){
			throw new ExcecaoSistemaDeMercado("Fornevedor não encontrado");
		}
		
	}
}
