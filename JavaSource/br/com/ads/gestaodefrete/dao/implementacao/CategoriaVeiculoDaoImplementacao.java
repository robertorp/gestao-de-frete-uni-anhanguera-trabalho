package br.com.ads.gestaodefrete.dao.implementacao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ads.gestaodefrete.dao.CategoriaVeiculoDao;
import br.com.ads.gestaodefrete.fabricas.FabricaConexaoBancoDados;
import br.com.ads.gestaodefrete.modelo.CategoriaVeiculo;

public class CategoriaVeiculoDaoImplementacao implements CategoriaVeiculoDao {

	private EntityManager entityManager;
	
	public CategoriaVeiculoDaoImplementacao() {
		this.entityManager = FabricaConexaoBancoDados.entityManager();
	}

	@Override
	public void salvar(CategoriaVeiculo categoriaVeiculo) {
		
		this.entityManager.getTransaction().begin();
		
		this.entityManager.persist(categoriaVeiculo);
		
		this.entityManager.getTransaction().commit();
		
	}

	@Override
	public CategoriaVeiculo alterar(CategoriaVeiculo categoriaVeiculo) {
		
		this.entityManager.getTransaction().begin();
		
		CategoriaVeiculo categoriaVeiculoTemp = this.entityManager.merge(categoriaVeiculo);
		
		this.entityManager.getTransaction().commit();
		
		return categoriaVeiculoTemp;
	}

	@Override
	public void close() throws IOException {
		
		this.entityManager.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoriaVeiculo> listar() {

		String jpql = "from CategoriaVeiculo";
		
		Query query = entityManager.createQuery(jpql);
		
		return query.getResultList();
	}

	@Override
	public void deletar(CategoriaVeiculo categoriaVeiculo) {

		this.entityManager.getTransaction().begin();
		
		categoriaVeiculo = this.entityManager.merge(categoriaVeiculo);
		this.entityManager.remove(categoriaVeiculo);
		
		this.entityManager.getTransaction().commit();
		
	}

	@Override
	public CategoriaVeiculo buscar(Integer idCategoriaVeiculo) {
		
		CategoriaVeiculo categoriaVeiculo;
		
		this.entityManager.getTransaction().begin();
		
		categoriaVeiculo = this.entityManager.find(CategoriaVeiculo.class, idCategoriaVeiculo);
		
		this.entityManager.getTransaction().commit();
		
		return categoriaVeiculo;
		
	}

}
