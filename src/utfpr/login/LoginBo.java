package utfpr.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;

import utfpr.usuario.Usuario;
import utfpr.util.HibernateHelper;
import utfpr.util.JsfHelper;
 


@ManagedBean
@SessionScoped
public class LoginBo {
	
	public String conectar() {
		
		Login login = (Login)JsfHelper.getSessionAttribute("login");		
		System.out.println("Usuario"+login.getUserId());
		System.out.println("senha"+login.getSenha());		
		
		try {
			Session hSession = HibernateHelper.openSession();
			Usuario usu = (Usuario)hSession.get(Usuario.class,login.getUserId());
			if(usu != null) {
			   if (!usu.getSenha().equals(login.getSenha())){
				  JsfHelper.addErrorMessage("Senha invalida");
				  return "";
			   }else {
				   return "/Menu/menu.jsf";
			   }	
			   
			}else {
				JsfHelper.addErrorMessage("Usuario invalido");
				return "";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
