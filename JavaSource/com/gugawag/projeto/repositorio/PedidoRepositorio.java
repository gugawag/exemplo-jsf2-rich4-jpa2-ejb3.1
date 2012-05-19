package com.gugawag.projeto.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gugawag.projeto.modelo.Pedido;

@Stateless
public class PedidoRepositorio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="projeto-PU")
	private EntityManager em;
	
	public void cadastrarPedido(Pedido pedido){
		em.persist(pedido);
	}
	
	public List<Pedido> getPedidos(){
		return em.createQuery("from Pedido").getResultList();
	}
	
}
