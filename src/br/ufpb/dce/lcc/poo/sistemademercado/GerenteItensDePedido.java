package br.ufpb.dce.lcc.poo.sistemademercado;

import java.util.LinkedList;
import java.util.List;

public class GerenteItensDePedido {
	private List<ItemDePedido> itensPedido;
	
	
	public GerenteItensDePedido(){
		this.itensPedido  = new LinkedList <ItemDePedido>();
	
	}

	public void cadastraItem(ItemDePedido item) {
		this.itensPedido.add(item);
	}

	public ItemDePedido pesquisaItemDePedido( int numItem) {
		for (ItemDePedido i: this.itensPedido) {
			if (i.getNumeroDeItem() == numItem) {
				return i;
			}
		}
		throw new ExcecaoSistemaDeMercado ("Item Inexistente!");
	}

	public List<ItemDePedido> buscarItemDePedido() {
		if(itensPedido.size()> 0){
			return this.itensPedido;
		}
		else{
			return null;
		}
	}

	public void remover(int numItem) {
		boolean remove = false;
		for(ItemDePedido i: this.itensPedido){
			if(i.getNumeroDeItem() == numItem){
				this.itensPedido.remove(i);
				remove = true;
				break;
			}
		}
		if(!remove){
			throw new ExcecaoSistemaDeMercado("Item Inexistente");
		}
		
	}

	

	
}
