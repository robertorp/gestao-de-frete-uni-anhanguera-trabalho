package br.com.ads.gestaodefrete.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.ads.gestaodefrete.controle.UsuarioControle;
import br.com.ads.gestaodefrete.fabricas.FabricaControle;
import br.com.ads.gestaodefrete.modelo.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	
	private Usuario usuario;
	
	public String entrar() {
		
		UsuarioControle usuarioControle = FabricaControle.getUsuarioControle();
		
		if(usuarioControle.efetuarLogin(this.getUsuario()) != null)
			return "menuprincipal";
		else
			return "";
		
	}

	public Usuario getUsuario() {
		
		if(this.usuario == null) {
			this.usuario = new Usuario();
		}
		
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String sessionInvalidate() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
	    session.invalidate();
		
		return "index";
	}

}
