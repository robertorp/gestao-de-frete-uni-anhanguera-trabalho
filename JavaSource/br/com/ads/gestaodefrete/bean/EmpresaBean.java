package br.com.ads.gestaodefrete.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.ads.gestaodefrete.controle.EmpresaControle;
import br.com.ads.gestaodefrete.fabricas.FabricaControle;
import br.com.ads.gestaodefrete.modelo.Empresa;

@ManagedBean
@RequestScoped
public class EmpresaBean {
	
	private Empresa empresa;
	private EmpresaControle empresaControle;
	
	@PostConstruct
	public void init() {
		this.empresaControle = FabricaControle.getEmpresaControle();
		this.empresa = this.empresaControle.buscar();
		this.close();
	}

	public Empresa getEmpresa() {
		
		if(this.empresa == null) {
			this.empresa = new Empresa();
		}
		
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void salvar() {
		this.empresaControle = FabricaControle.getEmpresaControle();
		this.empresaControle.salvarOuAlterar(empresa);
		this.close();
	}

	private void close(){
		try {
			this.empresaControle.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
