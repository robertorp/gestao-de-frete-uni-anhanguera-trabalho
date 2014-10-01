package br.com.ads.gestaodefrete.dao;

import java.io.Closeable;

import br.com.ads.gestaodefrete.modelo.Empresa;

public interface EmpresaDao extends Closeable {
	
	public void salvar(Empresa empresa);
	
	public Empresa alterar(Empresa empresa);
	
	public Empresa buscar();

}
