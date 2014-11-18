package br.com.ads.gestaodefrete.controle.implementacao;

import java.io.IOException;
import java.util.List;

import br.com.ads.gestaodefrete.controle.VeiculoControle;
import br.com.ads.gestaodefrete.dao.VeiculoDao;
import br.com.ads.gestaodefrete.fabricas.FabricaDao;
import br.com.ads.gestaodefrete.modelo.Veiculo;

public class VeiculoControleImplementacao implements VeiculoControle {

	private VeiculoDao veiculoDao;
	
	public VeiculoControleImplementacao() {
		this.veiculoDao = FabricaDao.getVeiculoDao();
	}
	
	@Override
	public void close() throws IOException {
		
		this.veiculoDao.close();
		
	}

	private void salvar(Veiculo veiculo) {
		
		this.veiculoDao.salvar(veiculo);
		
	}

	private Veiculo alterar(Veiculo veiculo) {
		
		return this.veiculoDao.alterar(veiculo);
	}

	
	@Override
	public Veiculo salvarOuAlterar(Veiculo veiculo) {
		if(veiculo.getId() != null) {
			veiculo = this.alterar(veiculo);
		}
		else {
			this.salvar(veiculo);
		}
		return veiculo;
	}

	@Override
	public List<Veiculo> listar() {

		return this.veiculoDao.listar();
	}

	@Override
	public void deletar(Veiculo veiculo) {

		this.veiculoDao.deletar(veiculo);
		
	}

}
