package br.com.ads.gestaodefrete.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.ads.gestaodefrete.controle.CategoriaVeiculoControle;
import br.com.ads.gestaodefrete.controle.VeiculoControle;
import br.com.ads.gestaodefrete.fabricas.FabricaControle;
import br.com.ads.gestaodefrete.modelo.CategoriaVeiculo;
import br.com.ads.gestaodefrete.modelo.Veiculo;

@ManagedBean
@RequestScoped
public class VeiculoBean {
	
	private Veiculo veiculo;
	private CategoriaVeiculoControle categoriaVeiculoControle;
	private VeiculoControle veiculoControle;
	private List<SelectItem> selectItemsCategoriaVeiculos;
	private String acaoRegistro;
	
	private List<CategoriaVeiculo> buscaTodasCategoriasVeiculo() {
	
		List<CategoriaVeiculo> categoriaVeiculos = null;
		
		if(categoriaVeiculos == null) {
			this.categoriaVeiculoControle = FabricaControle.getCategoriaVeiculoControle();
			
			try {
				categoriaVeiculos = this.categoriaVeiculoControle.listar();
				this.categoriaVeiculoControle.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return categoriaVeiculos;
	}
	
	public void novoRegistro() {
		this.veiculo = new Veiculo();
		this.acaoRegistro = "novo";
	}
	
	
	public String salvar() {
		try {
			this.veiculoControle = FabricaControle.getVeiculoControle();
			this.veiculoControle.salvarOuAlterar(this.veiculo);
			this.veiculoControle.close();
			
			//this.categoriaVeiculos = null;
			return "";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public List<SelectItem> getSelectItemsCategoriaVeiculos() {
		if(this.selectItemsCategoriaVeiculos == null) {
			this.selectItemsCategoriaVeiculos = new ArrayList<SelectItem>();
			this.buscaTodasCategoriasVeiculo().forEach((categoriaVeiculo) -> {
				SelectItem si = new SelectItem(categoriaVeiculo, categoriaVeiculo.getDescricao());
				this.selectItemsCategoriaVeiculos.add(si);
			});
		}
		return this.selectItemsCategoriaVeiculos;
	}

	public Veiculo getVeiculo() {
		if(this.veiculo == null) {
			this.veiculo = new Veiculo();
		}
		
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getAcaoRegistro() {
		return acaoRegistro;
	}

	public void setAcaoRegistro(String acaoRegistro) {
		this.acaoRegistro = acaoRegistro;
	}
}
