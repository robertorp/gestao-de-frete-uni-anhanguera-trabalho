package br.com.ads.gestaodefrete.dao.implementacao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import br.com.ads.gestaodefrete.dao.UsuarioDao;
import br.com.ads.gestaodefrete.fabricas.FabricaConexaoBancoDados;
import br.com.ads.gestaodefrete.modelo.Usuario;

public class UsuarioDaoImplementacao implements UsuarioDao {

	private EntityManager entityManager;
	
	
	public UsuarioDaoImplementacao() {
		this.instanciaEM();
	}
	
	private void instanciaEM() {
		this.entityManager = FabricaConexaoBancoDados.entityManager();
	}
	
//	/**
//	 * Faz a injeção de dependencia automaticamente (o JPA se encarrega de instânciar essa variável)
//	 * @param entityManager
//	 */
//	@PersistenceContext
//	public void setEntityManager(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}
	
	
	@Override
	public Usuario efetuarLogin(Usuario usuario) {
		
		// é parecido com select mas não é ! estou selecionando um objeto e não uma tabela!
		String jpql = "from Usuario u where u.login = :login and u.senha = :senha";
		
		Query query = entityManager.createQuery(jpql);
		
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		
		Usuario usuarioVolta;
		
		
		try {
			usuarioVolta = (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			usuarioVolta = null;
		}
		
		this.close();
		
		this.entityManager = null;
		
		return usuarioVolta;
	}
	
	@Override
	public void close() {
		
		entityManager.close();
		
		
	}

}
