package com.gugawag.projeto.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.gugawag.projeto.modelo.Usuario;
import com.gugawag.projeto.repositorio.UsuarioRepositorio;

@Stateless
public class CadastroUsuarioService {
	
	@EJB
	private UsuarioRepositorio usuarioRepositorio;

	public void cadastrarUsuario(Usuario usuario) throws UsuarioJahCadatradoException{
		Usuario usuarioPesquisado = usuarioRepositorio.getUsuarioPorLogin(usuario.getLogin());
		if (usuarioPesquisado != null){
			throw new UsuarioJahCadatradoException("Usu‡rio " + usuario + " j‡ cadastrado!");
		}
		usuarioRepositorio.cadastrarUsuario(new Usuario(usuario.getLogin(), usuario.getCpf()));
	}

	public List<Usuario> getUsuarios() {
		return usuarioRepositorio.getUsuarios();
	}
}
