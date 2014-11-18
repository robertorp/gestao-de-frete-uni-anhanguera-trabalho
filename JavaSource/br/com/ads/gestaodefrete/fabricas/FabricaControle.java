package br.com.ads.gestaodefrete.fabricas;

import br.com.ads.gestaodefrete.controle.CategoriaVeiculoControle;
import br.com.ads.gestaodefrete.controle.EmpresaControle;
import br.com.ads.gestaodefrete.controle.UsuarioControle;
import br.com.ads.gestaodefrete.controle.VeiculoControle;
import br.com.ads.gestaodefrete.controle.implementacao.CategoriaVeiculoControleImplementacao;
import br.com.ads.gestaodefrete.controle.implementacao.EmpresaControleImplementacao;
import br.com.ads.gestaodefrete.controle.implementacao.UsuarioControleImplementacao;
import br.com.ads.gestaodefrete.controle.implementacao.VeiculoControleImplementacao;

public class FabricaControle {

	public static UsuarioControle getUsuarioControle() {
		return new UsuarioControleImplementacao();
	}

	public static EmpresaControle getEmpresaControle() {
		return new EmpresaControleImplementacao();
	}

	public static CategoriaVeiculoControle getCategoriaVeiculoControle() {
		return new CategoriaVeiculoControleImplementacao();
	}
	
	public static VeiculoControle getVeiculoControle() {
		return new VeiculoControleImplementacao();
	}

}
