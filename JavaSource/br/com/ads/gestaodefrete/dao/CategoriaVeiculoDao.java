package br.com.ads.gestaodefrete.dao;

import java.io.Closeable;
import java.util.List;

import br.com.ads.gestaodefrete.modelo.CategoriaVeiculo;

public interface CategoriaVeiculoDao extends Closeable {
	
	public void salvar(CategoriaVeiculo categoriaVeiculo);
	
	public CategoriaVeiculo alterar(CategoriaVeiculo categoriaVeiculo);
	
	public List<CategoriaVeiculo> listar();
	
	public void deletar(CategoriaVeiculo categoriaVeiculo);

}
