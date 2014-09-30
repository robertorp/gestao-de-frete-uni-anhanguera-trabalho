package br.com.ads.gestaodefrete.dao;

import java.io.Closeable;

import br.com.ads.gestaodefrete.modelo.Usuario;

public interface UsuarioDao extends Closeable {
	
	
	public Usuario efetuarLogin(Usuario usuario);
	
	
}
