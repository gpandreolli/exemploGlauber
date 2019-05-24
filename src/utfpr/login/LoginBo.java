package utfpr.login;

import javax.faces.context.FacesContext;

import org.apache.tomcat.util.log.SystemLogHandler;

import utfpr.util.JsfHelper;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 


@ManagedBean
@SessionScoped
public class LoginBo {
	
	public String conectar() {
		
		Login login = (Login)JsfHelper.getSessionAttribute("login");		
		System.out.println("Usuario"+login.getUserId());
		System.out.println("senha"+login.getSenha());		
		
		if (login.getUserId().toUpperCase().equals("ADM") && login.getSenha().equals("123")) {
			JsfHelper.addMessage("Usuario Conectado");			
					limpar();
				return "/Menu/menu.jsf";
		}else {
				login.setUserId("xxx");
				
				JsfHelper.setSessionAttribute("login", login);
				JsfHelper.addErrorMessage("Usuário não cadastrado ou senha inválida");
				return "";
		}
		
		
	}
	
	public String limpar() {
		System.out.println("loginBo.limpar");
		JsfHelper.setSessionAttribute("login", new Login());
		return "/login.jsf";
		
	}

}
