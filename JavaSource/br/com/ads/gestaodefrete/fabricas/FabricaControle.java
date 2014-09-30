package br.com.ads.gestaodefrete.fabricas;

import br.com.ads.gestaodefrete.controle.UsuarioControle;
import br.com.ads.gestaodefrete.controle.implementacao.UsuarioControleImplementacao;

public class FabricaControle {

	public static UsuarioControle getUsuarioControle() {
		return new UsuarioControleImplementacao();
	}

}
