package br.com.ads.gestaodefrete.fabricas;
import br.com.ads.gestaodefrete.dao.CategoriaVeiculoDao;
import br.com.ads.gestaodefrete.dao.EmpresaDao;
import br.com.ads.gestaodefrete.dao.UsuarioDao;
import br.com.ads.gestaodefrete.dao.implementacao.CategoriaVeiculoDaoImplementacao;
import br.com.ads.gestaodefrete.dao.implementacao.EmpresaDaoImplementacao;
import br.com.ads.gestaodefrete.dao.implementacao.UsuarioDaoImplementacao;

public class FabricaDao {
	
	public static UsuarioDao getUsuarioDao() {
		return (UsuarioDao) new UsuarioDaoImplementacao();
	}
	
	public static EmpresaDao getEmpresaDao() {
		return (EmpresaDao) new EmpresaDaoImplementacao();
	}

	public static CategoriaVeiculoDao getCategoriaVeiculoDao() {
		
		return (CategoriaVeiculoDao) new CategoriaVeiculoDaoImplementacao();
	}
	

}
