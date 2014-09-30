package br.com.ads.gestaodefrete.seguranca;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import br.com.ads.gestaodefrete.bean.UsuarioBean;

public class Permissao implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {

		FacesContext facesContext = event.getFacesContext();
		     String currentPage = facesContext.getViewRoot().getViewId();
		 
		     boolean isLoginPage = (currentPage.lastIndexOf("index.xhtml") > -1);
		     HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		     UsuarioBean usuarioBean = (UsuarioBean) session.getAttribute("usuarioBean");
		     
		     if (usuarioBean == null || !isLoginPage && usuarioBean.getUsuario().getIdUsuario() == null) {
		       NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
		       nh.handleNavigation(facesContext, null, "index");
		     }
		
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
