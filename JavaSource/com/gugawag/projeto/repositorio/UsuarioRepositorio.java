package com.gugawag.projeto.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gugawag.projeto.modelo.Usuario;

@Stateless
public class UsuarioRepositorio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="projeto-PU")
	private EntityManager em;
	
	public void cadastrarUsuario(Usuario usuario){
		em.persist(usuario);
		
		//Mostrando abaixo que com sessão do hibernate aberta (entityManager de JPA), ao alterar um objeto gerenciado
		//será alterado automaticamente no banco de dados (update, delete etc)
		usuario.setLogin(usuario.getLogin() + " - alterado");
	}
	
	public List<Usuario> getUsuarios(){
		return em.createQuery("from Usuario").getResultList();
	}
	
	public Usuario getUsuarioPorLogin(String login){
		List<Usuario> usuarios = em.createQuery("from Usuario u where u.login=:l").setParameter("l", login).getResultList();
		if (usuarios != null && usuarios.size()>0){
			return usuarios.get(0);
		}
		return null;
	}
	
	public List<Usuario> getUsuarioPorCPF(String cpf){
		return em.createQuery("from Usuario u where u.cpf like :inicio").setParameter("inicio", cpf+"%").getResultList();
	}
	
	public List<Usuario> getUsuariosMais1Mensagem(){
		return em.createQuery("from Usuario u where SIZE(u.mensagens)>1 ").getResultList();
	}
	
	public void remover(Usuario usuario){
		usuario = em.merge(usuario);
		em.remove(usuario);
	}

	public void atualizar(Usuario usuario) {
		em.merge(usuario);
	}

}
