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
	
	@Test
	public void cadastrarFuncionarioNoSistema () {
		sistema.cadastraFuncionario("edu","12345","Caixa");
		assertNotNull(sistema.pesquisaFuncionarioPorNome("edu"));
	}
	@Test
	public void removerFuncionarioDoSistemaPorCPF () {
		sistema.cadastraFuncionario("edu","123","Caixa");
		sistema.removeFuncionarioPorCPF("123");
		assertNull (sistema.pesquisaFuncionarioPorCPF("12345"));
	}
	@Test
	public void pesquisarFuncionarioNoSistemaPeloNome () {
		this.cadastrarFuncionarioNoSistema();
		assertNotNull(sistema.pesquisaFuncionarioPorNome("edu"));
	}
	@Test
	public void pesquisarFuncionarioNoSistemaPeloCPF () {
		this.cadastrarFuncionarioNoSistema(); 
		assertNotNull(sistema.pesquisaFuncionarioPorCPF("12345"));
	}
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void cadastrarMesmoFuncionarioNoSistema () {
		sistema.cadastraFuncionario("edu","12345", "Caixa");
		sistema.cadastraFuncionario("edu","12345", "Caixa");
	}
	@Test (expected = ExcecaoSistemaDeMercado.class)
	public void removerFuncionarioPorCPFQueNaoEstaNoSistema () {
		sistema.removeFuncionarioPorCPF("32344");
	}
	@Test
	public void cadastrarProduto(){
		sistema.cadastraProduto("leite", 1234, 8.00);
		assertNotNull(sistema.pesquisaProdutoPorNome("leite"));
		
	}
	@Test
	public void pesquisarProdutoNome(){
		this.cadastrarProduto();
		assertNotNull(sistema.pesquisaProdutoPorNome("leite"));
	}
	@Test (expected = ExcecaoSistemaDeProduto.class)
	public void RemoverProduto(){
		sistema.removeProdutoPorNome("leite");		
	}
	@Test
	public void pesquisarProdutoPorCodigo(){
		this.cadastrarProduto();
		assertNotNull(sistema.pesquisaProdutoPorCodigo(1234));
	}
	@Test
	public void cadastrarFornecedor(){
		sistema.cadastraFornecedor("Fornecedor de Leite", "Rio Tinto", 1015,"1015-2020");
		assertNotNull(sistema.pesquisaFornecedorPeloNome("Fornecedor de Leite"));
	}
	@Test
	public void pesquisaPorFornecedor(){
		this.cadastrarFornecedor();
		assertNotNull(sistema.pesquisaFornecedorPeloNome("Fornecedor de Leite"));
	}
	@Test (expected = ExcecaoSistemaDeFornecedor.class)
	public void removerFornecedor(){
		sistema.removerFornecedorPornome("Fornecedor de Leite");
	}
	@Test
	public void cadastrarCliente(){
		sistema.cadastroDeCliente("Fabio","1212121","Centro");
		assertNotNull(sistema.pesquisaClientePorNome("Fabio"));
	}
	
	
			
}