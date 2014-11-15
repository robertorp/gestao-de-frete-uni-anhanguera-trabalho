package br.com.ads.gestaodefrete.controle.implementacao;

import java.io.IOException;
import java.util.List;

import br.com.ads.gestaodefrete.controle.CategoriaVeiculoControle;
import br.com.ads.gestaodefrete.dao.CategoriaVeiculoDao;
import br.com.ads.gestaodefrete.fabricas.FabricaDao;
import br.com.ads.gestaodefrete.modelo.CategoriaVeiculo;

public class CategoriaVeiculoControleImplementacao implements CategoriaVeiculoControle {

	private CategoriaVeiculoDao categoriaVeiculoDao;
	
	public CategoriaVeiculoControleImplementacao() {
		this.categoriaVeiculoDao = FabricaDao.getCategoriaVeiculoDao();
	}
	
	private void salvar(CategoriaVeiculo categoriaVeiculo) {
		
		this.categoriaVeiculoDao.salvar(categoriaVeiculo);
		
	}

	private CategoriaVeiculo alterar(CategoriaVeiculo categoriaVeiculo) {
		
		return this.categoriaVeiculoDao.alterar(categoriaVeiculo);
	}

	@Override
	public CategoriaVeiculo salvarOuAlterar(CategoriaVeiculo categoriaVeiculo) {

		if(categoriaVeiculo.getId() != null) {
			categoriaVeiculo = this.alterar(categoriaVeiculo);
		}
		else {
			this.salvar(categoriaVeiculo);
		}
		return categoriaVeiculo;
	}

	@Override
	public void close() throws IOException {

		this.categoriaVeiculoDao.close();
		
	}

	@Override
	public List<CategoriaVeiculo> listar() {
		return this.categoriaVeiculoDao.listar();
	}

}
