package br.com.ads.gestaodefrete.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.ads.gestaodefrete.controle.CategoriaVeiculoControle;
import br.com.ads.gestaodefrete.fabricas.FabricaControle;
import br.com.ads.gestaodefrete.modelo.CategoriaVeiculo;

@ManagedBean
@RequestScoped
public class CategoriaVeiculoBean {
	
	private CategoriaVeiculoControle categoriaVeiculoControle;
	private CategoriaVeiculo categoriaVeiculo;
	
	public void salvar() {
		
		
		try {
			this.categoriaVeiculoControle = FabricaControle.getCategoriaVeiculoControle();
			this.categoriaVeiculoControle.salvarOuAlterar(this.categoriaVeiculo);
			this.categoriaVeiculoControle.close();
			
			this.categoriaVeiculo = new CategoriaVeiculo();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public CategoriaVeiculo getCategoriaVeiculo() {
		if(this.categoriaVeiculo == null) {
			this.categoriaVeiculo = new CategoriaVeiculo();
		}
		return this.categoriaVeiculo;
	}

	public void setCategoriaVeiculo(CategoriaVeiculo categoriaVeiculo) {
		this.categoriaVeiculo = categoriaVeiculo;
	}
	
	private List<CategoriaVeiculo> categoriaVeiculos = null;
	
	public List<CategoriaVeiculo> listar() {
		
		
		if(this.categoriaVeiculos == null) {
			try {
				this.categoriaVeiculoControle = FabricaControle.getCategoriaVeiculoControle();
				this.categoriaVeiculos = this.categoriaVeiculoControle.listar();
				this.categoriaVeiculoControle.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return this.categoriaVeiculos;
	}

}
