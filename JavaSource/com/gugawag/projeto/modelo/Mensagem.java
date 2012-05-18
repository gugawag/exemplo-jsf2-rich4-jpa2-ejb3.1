package com.gugawag.projeto.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mensagem {
	
	
	@Id @GeneratedValue
	private int codigo;
	private String texto;
	public Mensagem() {
		super();
	}
	
	public Mensagem(String texto) {
		super();
		this.texto = texto;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
