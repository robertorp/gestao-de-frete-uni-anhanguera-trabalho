package br.com.ads.gestaodefrete.fabricas;
import br.com.ads.gestaodefrete.dao.UsuarioDao;
import br.com.ads.gestaodefrete.dao.implementacao.UsuarioDaoImplementacao;

public class FabricaDao {
	
	public static UsuarioDao getUsuarioDao() {
		return (UsuarioDao) new UsuarioDaoImplementacao();
	}
	

}
