package br.com.ads.gestaodefrete.controle;

import java.io.Closeable;
import java.util.List;

import br.com.ads.gestaodefrete.modelo.Veiculo;

public interface VeiculoControle extends Closeable {

	public Veiculo salvarOuAlterar(Veiculo veiculo);
	
	public List<Veiculo> listar();
	
	public void deletar(Veiculo veiculo);
	
}
