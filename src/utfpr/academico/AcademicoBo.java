package utfpr.academico;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import utfpr.login.Login;

@ManagedBean
@SessionScoped
public class AcademicoBo {
	
	public String salvar() {
	Academico academico = (Academico)FacesContext.getCurrentInstance().getExternalContext().
			getSessionMap().get("academico");
			
	
		if (academico.getSexo().toUpperCase().equals("F") || academico.getSexo().toUpperCase().equals("M") ) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Academico Salvo Com sucesso"));
			limpar();
			return "academicoSalvo.jsf";
		}else {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acadmeico Nao foi Salvo", "Sexo Invalido"));
			return "academicoNaoSalvo.jsf";
		}
	
	}
	
	public void limpar() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().
				getSessionMap();
		sessionMap.put("Login", new Login());
		
	}

}
