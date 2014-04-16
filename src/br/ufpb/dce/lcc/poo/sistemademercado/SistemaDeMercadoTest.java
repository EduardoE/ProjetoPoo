package br.ufpb.dce.lcc.poo.sistemademercado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaDeMercadoTest {
	private SistemaDeMercado sistema;
   
	@Before
	public void iniciar () {
		sistema = new SistemaDeMercado ();
		assertFalse ("O sistema iniciou acabado", sistema.finalizou());
	}
	
	@Test                                                                      // TESTES FUNCIONARIO
	public void cadastrarFuncionarioNoSistema () {
		Funcionario f = new Funcionario("edu","12345","Caixa");
		sistema.cadastraFuncionario(f);
		Funcionario salvo = sistema.pesquisaFuncionarioPorNome("edu");
		assertEquals(f, salvo);
	}
	
	@Test                                                                      
	public void cadastrarMaisDeUmFuncionarioNoSistema () {
		this.cadastrarFuncionarioNoSistema();
		Funcionario f2 =  new Funcionario("fabio","123","Vendedor");
		sistema.cadastraFuncionario (f2);
		Funcionario salvo = sistema.pesquisaFuncionarioPorCPF(f2.getCpf());
		assertEquals (f2, salvo);
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void removerFuncionarioDoSistemaPorCPF () {
		this.cadastrarFuncionarioNoSistema();   
		sistema.removeFuncionarioPorCPF("12345");
		sistema.pesquisaFuncionarioPorCPF("12345");
	}
	
	@Test
	public void pesquisarFuncionarioNoSistemaPeloNome () {
		Funcionario f = new Funcionario ("João", "112233", "Gerente");
		sistema.cadastraFuncionario(f);
		Funcionario salvo = sistema.pesquisaFuncionarioPorNome("João");
		assertEquals (f, salvo);
	}
	
	@Test
	public void pesquisarFuncionarioNoSistemaPeloCPF () {
		Funcionario f = new Funcionario ("João", "112233", "Gerente");
		sistema.cadastraFuncionario(f);
		Funcionario salvo = sistema.pesquisaFuncionarioPorCPF("112233");
		assertEquals (f, salvo);
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void cadastrarMesmoFuncionarioNoSistema () {
		this.cadastrarFuncionarioNoSistema();
		this.cadastrarFuncionarioNoSistema();
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void removerFuncionarioQueNaoEstaNoSistema () {
		sistema.removeFuncionarioPorCPF("32344");
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void pesquisarFuncionarioPorCPFQueNaoEstaNoSistema(){
		sistema.pesquisaFuncionarioPorCPF("101010");
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void pesquisarFuncionarioPorNomeQueNaoEstaNoSistema(){
		sistema.pesquisaFuncionarioPorNome("edu");
	}
	
	@Test                                                                             //TESTES PRODUTO
	public void cadastrarProduto(){
		Produto p = new Produto ("leite", 1234, 8.00);
		sistema.cadastraProduto(p);
		Produto salvo = sistema.pesquisaProdutoPorCodigo(1234);
		assertEquals (p, salvo);
	}
	
	@Test                                                                             
	public void cadastrarMaisDeUmProduto(){
		this.cadastrarProduto();
		Produto p2 = new Produto ("biscoito", 5555, 3.50);
		sistema.cadastraProduto(p2);
		Produto salvo2 = sistema.pesquisaProdutoPorCodigo(5555);
		assertEquals (p2, salvo2);
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void cadastrarMesmoProduto () {
		this.cadastrarProduto();
		this.cadastrarProduto();
	} 
	
	@Test
	public void alterarPrecoDeProduto () {
		this.cadastrarProduto();
		Produto p = new Produto ("leite",1234,3.40);
		sistema.alterarProduto(p);
		Produto salvo = sistema.pesquisaProdutoPorCodigo(1234);
		assertEquals(p, salvo);
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void pesquisarProdutoInexistentePassandoNome () {
		sistema.pesquisaProdutoPorNome("feijão");
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void removerProdutoPassandoCodigo(){
		this.cadastrarProduto();
		sistema.removeProdutoPorCodigo(1234);
		sistema.pesquisaProdutoPorCodigo(1234);
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void removerProdutoPorInexistentePassandoCodigo () {
		sistema.removeProdutoPorCodigo(10454);
	} 
	
	@Test
	public void pesquisarProdutoPorCodigo(){
		Produto p = new Produto ("Açúcar", 4321, 1.00);
		sistema.cadastraProduto(p);
		Produto salvo = sistema.pesquisaProdutoPorCodigo(4321);
		assertEquals (p, salvo);
	}
	
	@Test                                                                                  //TESTES FORNECEDOR
	public void cadastrarFornecedor(){
		Fornecedor f = new Fornecedor ("Fornecedor de Leite", "Rio Tinto", 88888888,"12345678");
		sistema.cadastraFornecedor(f);
		Fornecedor salvo = sistema.pesquisaFornecedorPassandoCnpj("12345678");
		assertEquals (f, salvo);
	}
	
	@Test                                                                                  
	public void cadastrarMaisDeUmFornecedor(){
		this.cadastrarFornecedor();
		Fornecedor f2 = new Fornecedor("Fornecedor de Chocolate", "João Pessoa", 21212121,"09872");
		sistema.cadastraFornecedor(f2);
		Fornecedor salvo2 = sistema.pesquisaFornecedorPassandoCnpj("09872");
		assertEquals(f2, salvo2);

	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void cadastraMesmoFornecedor () {
		this.cadastrarFornecedor();
		this.cadastrarFornecedor();
    }
	
	@Test
	public void pesquisarFornecedorPorCnpj(){
		Fornecedor fornecedor = new Fornecedor ("Fornecedor de Chocolate", "João Pessoa", 21212121,"09872");
		sistema.cadastraFornecedor(fornecedor);
		Fornecedor salvo = sistema.pesquisaFornecedorPassandoCnpj("09872");
		assertEquals (fornecedor, salvo);
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void pesquisarFornecedorInexistentePorCnpj () {
		sistema.pesquisaFornecedorPassandoCnpj("3333333");	
		
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void pesquisarFornecedorInexistentePorNome () {
		sistema.pesquisaFornecedorPeloNome("Fornecedor de Café");
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void removerFornecedor(){
		this.cadastrarFornecedor();
		sistema.removerFornecedorPorCnpj("12345678");
		sistema.pesquisaFornecedorPorCnpj("12345678");
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void removerFornecedorInexistente () {
		sistema.removerFornecedorPorCnpj("09872");
	}	
	
	@Test
	public void cadastrarCliente(){                                                  // TESTES CLIENTE
		Cliente cliente = new Cliente ("Adriano","2014","Centro");
		sistema.cadastroDeCliente(cliente);
		Cliente salvo = sistema.pesquisaClientePorCpf("2014");
		assertEquals (cliente, salvo);
	}
	
	@Test
	public void cadastrarMaisDeUmClienteCliente(){                                
		this.cadastrarCliente();
		Cliente cli = new Cliente("Fabia", "1234567", "Centro");
		sistema.cadastroDeCliente(cli);
		Cliente salvo = sistema.pesquisaClientePorCpf("1234567");
		assertEquals (cli, salvo);
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void cadastrarMesmoCliente () {
		this.cadastrarCliente();
		this.cadastrarCliente();
	}  
	
	@Test
	public void pesquisarClientePorNome(){
		Cliente cli = new Cliente ("Antonia", "44332211", "Centro");
		sistema.cadastroDeCliente(cli);
		Cliente salvo = sistema.pesquisaClientePorNome("Antonia");
		assertEquals (cli, salvo);
	}
	
	@Test
	public void pesquisarClientePorCpf(){
		Cliente cli = new Cliente ("Adriana", "55555", "Centro");
		sistema.cadastroDeCliente(cli);
		Cliente salvo = sistema.pesquisaClientePorCpf("55555");
		assertEquals (cli, salvo);
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void removerCliente(){
		this.cadastrarCliente();
		sistema.removeClientePorCpf("2014");
		sistema.pesquisaClientePorCpf ("2014");
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void pesquisarClienteInexistentePorNome () {
		sistema.pesquisaClientePorNome("Eduardo");
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void pesquisarClienteInexistentePorCpf () {
		sistema.pesquisaClientePorCpf("123456789");
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void removerClienteInexistente () {
		sistema.removeClientePorCpf("12345");
	}
	
	@Test
	public void iniciarCaixaDiario(){                          //Testes Operações para o caixa (Guarda os valores diários e o apurado geral do mercado)
		sistema.iniciaCaixaDiario ("16/10/2014");
		assertNotNull (sistema.pesquisaCaixaDiario("16/10/2014"));
	}
	
	@Test (expected = ExcecaoSistemaDeCaixa.class)
	public void inserirCaixaComDataJaExistente () {
		this.iniciarCaixaDiario();
		this.iniciarCaixaDiario();
	}
	
	@Test
	public void consultarCaixaDiario () {
		this.iniciarCaixaDiario();
		assertNotNull (sistema.pesquisaCaixaDiario("16/10/2014"));
	}																		
	
	@Test
	public void cadastrarItemDePedido(){
		Produto p = new Produto ("Leite", 123, 2.00);
		sistema.cadastraProduto(p);
		ItemDePedido item = new ItemDePedido (p,"Alimento", 3, 1);  // numero do item de pedido = 3
		sistema.cadastrarItemDePedido(item);
		ItemDePedido salvo = sistema.pesquisaItemDePedido(3);
		assertEquals (item, salvo);
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void pesquisarItemDePedidoInexistente () {
		sistema.itens.pesquisaItemDePedido(12);
	}
	
	@Test
	public void pesquisarItemDePedido () {
		this.cadastrarItemDePedido();
		assertNotNull (sistema.pesquisaItemDePedido(3));
	}
	
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void removerItemDePedidoPorNumeroDeItemInexixtente(){
		sistema.removeItemPedido(1);
	}
	
}









