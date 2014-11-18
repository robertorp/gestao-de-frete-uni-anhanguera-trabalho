package br.com.ads.gestaodefrete.controle;

import java.io.Closeable;
import java.util.List;

import br.com.ads.gestaodefrete.modelo.CategoriaVeiculo;

public interface CategoriaVeiculoControle extends Closeable {
	
	public CategoriaVeiculo salvarOuAlterar(CategoriaVeiculo categoriaVeiculo);
	
	public List<CategoriaVeiculo> listar();
	
	public void deletar(CategoriaVeiculo categoriaVeiculo);
	
	public CategoriaVeiculo buscar(Integer idCategoriaVeiculo);

}
