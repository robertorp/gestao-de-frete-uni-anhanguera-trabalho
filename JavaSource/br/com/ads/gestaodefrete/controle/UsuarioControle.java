package br.com.ads.gestaodefrete.controle;

import java.io.Closeable;

import br.com.ads.gestaodefrete.modelo.Usuario;

public interface UsuarioControle extends Closeable {
	
	public Usuario efetuarLogin(Usuario usuario);

}
