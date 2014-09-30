package br.com.ads.gestaodefrete.fabricas;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FabricaConexaoBancoDados {
	
	public static EntityManager entityManager() {
		
		return Persistence.createEntityManagerFactory("gestaodefrete").createEntityManager();
		
	}
	

}
