package br.com.ads.gestaodefrete.controle.implementacao;

import java.io.IOException;

import br.com.ads.gestaodefrete.controle.EmpresaControle;
import br.com.ads.gestaodefrete.dao.EmpresaDao;
import br.com.ads.gestaodefrete.fabricas.FabricaDao;
import br.com.ads.gestaodefrete.modelo.Empresa;

public class EmpresaControleImplementacao implements EmpresaControle {
	
	private EmpresaDao empresaDao;
	
	public EmpresaControleImplementacao() {
		this.empresaDao = FabricaDao.getEmpresaDao();
	}

	
	private void salvar(Empresa empresa) {
		
		this.empresaDao.salvar(empresa);
		
	}

	
	private Empresa alterar(Empresa empresa) {

		return this.empresaDao.alterar(empresa);
	}

	@Override
	public Empresa buscar() {

		return this.empresaDao.buscar();
	}
	
	@Override
	public void close() throws IOException {
		this.empresaDao.close();
		
	}

	@Override
	public Empresa salvarOuAlterar(Empresa empresa) {

		if(empresa.getIdEmpresa() != null) {
			empresa = this.alterar(empresa);
		}
		else {
			this.salvar(empresa);
		}
		
		return empresa;
	}

}
