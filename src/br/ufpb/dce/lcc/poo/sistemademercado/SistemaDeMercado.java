package br.ufpb.dce.lcc.poo.sistemademercado;

public class SistemaDeMercado {
	GerenteDeFuncionario funcionarios;
	GerenteDeProduto produtos;
	GerenteDeFornecedor fornecedores;
	GerenteDeCliente clientes;
	GerenteDeCaixa caixas;
	GerenteItensDePedido itens;
	
	public SistemaDeMercado () {
		funcionarios = new GerenteDeFuncionario ();
		produtos = new GerenteDeProduto ();
		fornecedores = new GerenteDeFornecedor();
		clientes = new GerenteDeCliente();
		caixas = new GerenteDeCaixa();
		itens = new GerenteItensDePedido ();
		
		
	}
	        
	public void cadastraFuncionario (Funcionario f) {
		funcionarios.cadastra (f);
	}
	public void removeFuncionarioPorCPF (String cpf) {
	    funcionarios.removePorCPF(cpf);	
	}
	public Funcionario pesquisaFuncionarioPorNome (String n) {
		return funcionarios.pesquisaPorNome(n);
	}
	public Funcionario pesquisaFuncionarioPorCPF (String cpf) {
		return funcionarios.pesquisaPorCPF(cpf);
	}
	
	public boolean finalizou () {
		return false;
	}

	public void cadastraProduto(Produto p) {
		produtos.cadastra(p);
		
	}

	public Produto pesquisaProdutoPorNome(String nome) {
		return produtos.pesquisaPorNome(nome);
		
	}

	public void removeProdutoPorCodigo(int cod) {
		produtos.remove(cod);
		
	}

	public Produto pesquisaProdutoPorCodigo(int codigo) {
		return produtos.pesquisaPorCodigo(codigo);
		
	}


	public void cadastraFornecedor(Fornecedor fornecedor) {
		this.fornecedores.cadastra(fornecedor);
	}

	public Fornecedor pesquisaFornecedorPeloNome(String nome) {
		return this.fornecedores.pesquisaPorNome(nome);
	}
	
	public Fornecedor pesquisaFornecedorPorCnpj (String cnpj) {
		return this.fornecedores.pesquisaPorCnpj(cnpj); 
	}

	public void removerFornecedorPorCnpj(String cnpj) {
		fornecedores.removeFornecedorPorCnpj(cnpj);
	}

	public void cadastroDeCliente(Cliente cli) {
		clientes.cadastra(cli);
		
	}

	public Cliente pesquisaClientePorNome(String nome) {
		return clientes.pesquisaPorNome(nome);
	}

	public Cliente pesquisaClientePorCpf(String cpf) {
		return clientes.pesquisaPorCpf(cpf);
	}

	public void removeClientePorCpf (String cpf) {
		clientes.removerClientePorCpf (cpf);
		
	}

	public void iniciaCaixaDiario (String data) {
		this.caixas.registrar(data);
	}

	public CaixaDiario pesquisaCaixaDiario(String data) {
        return this.caixas.pesquisaDiaria (data);
	}

	public void alterarProduto(Produto novo) {
		  this.produtos.altera (novo);
	}
	
	public Fornecedor pesquisaFornecedorPassandoCnpj(String cnpj) {
		return this.fornecedores.pesquisaPorCnpj(cnpj);
	}

	public ItemDePedido pesquisaItemDePedido(int numeroDoItem) {
		return this.itens.pesquisaItemDePedido ( numeroDoItem);
	}

	public void cadastrarItemDePedido(ItemDePedido i) {
		this.itens.cadastraItem(i);
		
	}

	public void removeItemPedido(int numItem) {
		itens.remover(numItem);
		
	}

	public void cadastraItemDePedido(ItemDePedido item) {
		
		
	}


	
	

	

	
	
	
	
}






