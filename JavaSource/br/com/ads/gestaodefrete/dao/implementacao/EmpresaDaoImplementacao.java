package br.com.ads.gestaodefrete.dao.implementacao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import javax.persistence.Query;

import br.com.ads.gestaodefrete.dao.EmpresaDao;
import br.com.ads.gestaodefrete.fabricas.FabricaConexaoBancoDados;
import br.com.ads.gestaodefrete.modelo.Empresa;

public class EmpresaDaoImplementacao implements EmpresaDao {

	
	private EntityManager entityManager;
	
	public EmpresaDaoImplementacao() {
		this.entityManager = FabricaConexaoBancoDados.entityManager();
	}
	
	@Override
	public void salvar(Empresa empresa) {

		this.entityManager.getTransaction().begin();
		
		this.entityManager.persist(empresa);
		
		this.entityManager.getTransaction().commit();
		
	}

	@Override
	public Empresa alterar(Empresa empresa) {
		
		this.entityManager.getTransaction().begin();
		
		Empresa empresatemp = this.entityManager.merge(empresa);
		
		this.entityManager.getTransaction().commit();
		
		return empresatemp;
		
	}

	@Override
	public Empresa buscar() {
		
		String jpql = "from Empresa";
		
		Query query = entityManager.createQuery(jpql);
		
		Empresa empresa;
		
		try {
			empresa = (Empresa) query.getSingleResult();
		} catch (NoResultException e) {
			empresa = null;
		}
		
		return empresa;
	}

	@Override
	public void close() {
		this.entityManager.close();
	}

}
