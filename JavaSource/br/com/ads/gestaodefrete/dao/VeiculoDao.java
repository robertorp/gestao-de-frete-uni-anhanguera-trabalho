package br.com.ads.gestaodefrete.dao;

import java.io.Closeable;
import java.util.List;

import br.com.ads.gestaodefrete.modelo.Veiculo;

public interface VeiculoDao extends Closeable {

	public void salvar(Veiculo veiculo);
	
	public Veiculo alterar(Veiculo veiculo);
	
	public List<Veiculo> listar();
	
	public void deletar(Veiculo veiculo);
	
}
