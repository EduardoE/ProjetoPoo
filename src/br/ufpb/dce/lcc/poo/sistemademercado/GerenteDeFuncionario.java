package br.ufpb.dce.lcc.poo.sistemademercado;

import java.util.LinkedList;
import java.util.List;

public class GerenteDeFuncionario {
    
	private List <Funcionario> funcionarios;
	
	public GerenteDeFuncionario () {
		this.funcionarios = new LinkedList <Funcionario>();
	}
	
	public void cadastra (Funcionario funcionario) {
		for (Funcionario f: this.funcionarios){
			if (f.getCpf().equals(funcionario.getCpf())){
				throw new ExcecaoSistemaDeMercado ("Funcionario já Existe!");
			}
		}
		funcionarios.add(funcionario);
	}
	
	public void removePorCPF(String cpf) {
		boolean removeu = false;
		for (Funcionario f: this.funcionarios) {
			if (f.getCpf().equals(cpf))
				this.funcionarios.remove(f);
				removeu = true;
				break;
		}
		if (!removeu) {
			throw new ExcecaoSistemaDeMercado ("Funcionario nao Existente no Sistema!");
		}
	}

	public Funcionario pesquisaPorNome(String nome) {
		for (Funcionario f: this.funcionarios) {
			if (f.getNome().equals(nome))
				return f;
		}
		throw new ExcecaoSistemaDeMercado ("Funcionário Inexistente!");
	}

	public Funcionario pesquisaPorCPF(String cpf) {
		for (Funcionario f: this.funcionarios) {
			if (f.getCpf().equals(cpf))
				return f;
		}
		throw new ExcecaoSistemaDeMercado ("Funcionário Inexixtente!"); 
	}
}
