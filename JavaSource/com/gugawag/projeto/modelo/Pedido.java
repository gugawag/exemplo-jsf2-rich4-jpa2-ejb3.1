package com.gugawag.projeto.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Pedido {
	
	@Id @GeneratedValue
	private int codigo;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
			name="item"	
			)
	private List<Produto> produtos;
	
	
	public Pedido() {
		super();
		produtos = new ArrayList<Produto>();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
