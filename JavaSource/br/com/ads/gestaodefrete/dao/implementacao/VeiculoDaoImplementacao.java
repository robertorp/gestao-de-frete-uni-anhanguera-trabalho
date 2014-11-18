package br.com.ads.gestaodefrete.dao.implementacao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ads.gestaodefrete.dao.VeiculoDao;
import br.com.ads.gestaodefrete.fabricas.FabricaConexaoBancoDados;
import br.com.ads.gestaodefrete.modelo.Veiculo;

public class VeiculoDaoImplementacao implements VeiculoDao {

	private EntityManager entityManager;
	
	public VeiculoDaoImplementacao() {
		this.entityManager = FabricaConexaoBancoDados.entityManager();
	}
	
	@Override
	public void close() throws IOException {
		
		this.entityManager.close();
		
	}

	@Override
	public void salvar(Veiculo veiculo) {
		
		this.entityManager.getTransaction().begin();
		
		this.entityManager.persist(veiculo);
		
		this.entityManager.getTransaction().commit();
		
	}

	@Override
	public Veiculo alterar(Veiculo veiculo) {
		
		this.entityManager.getTransaction().begin();
		
		Veiculo veiculoTemp = this.entityManager.merge(veiculo);
		
		this.entityManager.getTransaction().commit();
		
		return veiculoTemp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Veiculo> listar() {
		String jpql = "from Veiculo";
		
		Query query = entityManager.createQuery(jpql);
		
		return query.getResultList();
	}

	@Override
	public void deletar(Veiculo veiculo) {
		
		this.entityManager.getTransaction().begin();
		
		this.entityManager.remove(veiculo);
		
		this.entityManager.getTransaction().commit();
		
	}

}
