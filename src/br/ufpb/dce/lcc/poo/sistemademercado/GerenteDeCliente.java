package br.ufpb.dce.lcc.poo.sistemademercado;

import java.util.LinkedList;
import java.util.List;

public class GerenteDeCliente {
	private List <Cliente> clientes;
	
	public GerenteDeCliente(){
		this.clientes = new LinkedList<Cliente>();
	}

	public void cadastra(Cliente cli) {
		for (Cliente c: this.clientes) {
			if (c.getCpf().equals(cli.getCpf())) {
				throw new ExcecaoSistemaDeMercado ("Cliente já existe!");
			}
		}
		this.clientes.add(cli);
	}

	public Cliente pesquisaPorNome(String nome) {
		for(Cliente c: this.clientes){
			if(c.getNome().equals(nome)){
				return c;
			}
		}
		throw new ExcecaoSistemaDeMercado("Cliente Inexistente");
	}

	public Cliente pesquisaPorCpf(String cpf) {
		for(Cliente c: this.clientes){
			if(c.getCpf().equals(cpf)){
				return c;
			}
		}
		throw new ExcecaoSistemaDeMercado("Cliente Inexistente");
	}

	public void removerClientePorCpf(String cpf) {
		boolean remove = false;
		for(Cliente cli: this.clientes){
			if(cli.getCpf().equals(cpf)){
				this.clientes.remove(cli);
				remove = true;
				break;
			}
		}
		if(!remove){
			throw new ExcecaoSistemaDeMercado("Cliente Inexistente");
		}
	}
}








