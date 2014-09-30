package br.com.ads.gestaodefrete.controle.implementacao;

import java.io.IOException;

import br.com.ads.gestaodefrete.controle.UsuarioControle;
import br.com.ads.gestaodefrete.dao.UsuarioDao;
import br.com.ads.gestaodefrete.fabricas.FabricaDao;
import br.com.ads.gestaodefrete.modelo.Usuario;

public class UsuarioControleImplementacao implements UsuarioControle {

	private UsuarioDao usuarioDao;
	
	public UsuarioControleImplementacao() {
		this.usuarioDao = FabricaDao.getUsuarioDao();
	}
	

	@Override
	public Usuario efetuarLogin(Usuario usuario) {
		return this.usuarioDao.efetuarLogin(usuario);
	}
	
	@Override
	public void close() throws IOException {
		this.usuarioDao.close();
		
	}

}
