package com.gugawag.projeto.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Integer codigo;
	
	@Column(length=30)
	private String login;
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Temporal(TemporalType.TIME)
	private Date dataNascimento2;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento3;


	@OneToOne
	private Endereco endereco;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)    
	private List<Mensagem> mensagens;
	
	public Usuario(){
		this(null, null);
	}
	
	public Usuario(String login, String cpf) {
		super();
		this.login = login;
		this.cpf = cpf;
		mensagens = new ArrayList<Mensagem>();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", login=" + login + ", cpf="
				+ cpf + "]";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataNascimento2() {
		return dataNascimento2;
	}

	public void setDataNascimento2(Date dataNascimento2) {
		this.dataNascimento2 = dataNascimento2;
	}

	public Date getDataNascimento3() {
		return dataNascimento3;
	}

	public void setDataNascimento3(Date dataNascimento3) {
		this.dataNascimento3 = dataNascimento3;
	}
	

}
