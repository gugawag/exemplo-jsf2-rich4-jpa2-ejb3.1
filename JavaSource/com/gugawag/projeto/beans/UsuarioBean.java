package com.gugawag.projeto.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gugawag.projeto.modelo.Mensagem;
import com.gugawag.projeto.modelo.Usuario;
import com.gugawag.projeto.repositorio.UsuarioRepositorio;
import com.gugawag.projeto.service.CadastroUsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
	
	private Usuario usuario;
	
	public UsuarioBean(){
		usuario = new Usuario();
	}
	
	@EJB
	private CadastroUsuarioService usuarioService;
	
	@EJB
	private UsuarioRepositorio uRep;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	public List<Usuario> getUsuariosComCpfInicio(){
		return uRep.getUsuarioPorCPF("123");
	}
	
	public List<Usuario> getUsuariosMais1Mensagem(){
		return uRep.getUsuariosMais1Mensagem();
	}
	
	public String editar(Usuario usuario){
		this.usuario = usuario;
		return "editarUsuario";
	}
	
	public String editar(){
		uRep.atualizar(usuario);
		return "listagemUsuarios";
	}
	
	public String cadastrar(){
//		Usuario usuario = new Usuario("gugawag8", "123");
		List<Mensagem> mensagens = usuario.getMensagens();
		mensagens.add(new Mensagem("m8"));
		mensagens.add(new Mensagem("m9"));
		usuario.setDataNascimento(new Date());
		usuario.setDataNascimento2(new Date());
		usuario.setDataNascimento3(new Date());
		uRep.cadastrarUsuario(usuario);
		usuario = new Usuario();
//		Usuario usuarioInserido = uRep.getUsuarioPorLogin("gugawag8");
//		System.out.println(usuarioInserido);
//		for(Mensagem mensagem: usuarioInserido.getMensagens()){
//			System.out.println(mensagem.getTexto());
//		}
		return "ok";
	}
	
	public String remover(Usuario usuario){
		uRep.remover(usuario);
		return null;
	}

}
