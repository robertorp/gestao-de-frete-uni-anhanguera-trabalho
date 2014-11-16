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
	private List<CategoriaVeiculo> categoriaVeiculos = null;
	private String acaoRegistro;
	
	public void novoRegistro() {
		this.categoriaVeiculo = new CategoriaVeiculo();
		this.acaoRegistro = "novo";
	}
	
	public void alterar() {
		this.acaoRegistro = "editar";
	}
	
	public String salvar() {
		try {
			this.categoriaVeiculoControle = FabricaControle.getCategoriaVeiculoControle();
			this.categoriaVeiculoControle.salvarOuAlterar(this.categoriaVeiculo);
			this.categoriaVeiculoControle.close();
			
			this.categoriaVeiculos = null;
			return "";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String deletar() {
		try {
			this.categoriaVeiculoControle = FabricaControle.getCategoriaVeiculoControle();
			
			// aqui ele executa um update (merge do hibernate) para colocar o objeto dentro da sessão do hibernate
			this.categoriaVeiculo = this.categoriaVeiculoControle.salvarOuAlterar(this.categoriaVeiculo);
			
			// depois de colocar o objeto na sessão do hibernate você pode executar o deletar
			this.categoriaVeiculoControle.deletar(this.categoriaVeiculo);
			
			this.categoriaVeiculoControle.close();
			
			this.categoriaVeiculos = null;
			return "";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
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

	public String getAcaoRegistro() {
		return acaoRegistro;
	}

	public void setAcaoRegistro(String abrirEdicao) {
		this.acaoRegistro = abrirEdicao;
	}

}
