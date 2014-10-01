package br.com.ads.gestaodefrete.controle;

import java.io.Closeable;

import br.com.ads.gestaodefrete.modelo.Empresa;

public interface EmpresaControle extends Closeable {
	
	public Empresa salvarOuAlterar(Empresa empresa);
	
	public Empresa buscar();

}
