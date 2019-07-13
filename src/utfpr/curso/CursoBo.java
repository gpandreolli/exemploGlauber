package utfpr.curso;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.primefaces.event.SelectEvent;

import utfpr.util.HibernateHelper;
import utfpr.util.JsfHelper;


@ManagedBean
@SessionScoped
public class CursoBo {

	public void salvar() {
		Curso curso = (Curso)JsfHelper.getSessionAttribute("curso");
		try {
			HibernateHelper.save(curso);
			JsfHelper.addMessage("Registro salvo");
		} catch (Exception e) {
			JsfHelper.addErrorMessage("Erro ao salvar o registro "+e.toString());
		}
	}
	
	public void novo() {
		Map<String, Object> mapaDaSessao = FacesContext.getCurrentInstance().
				getExternalContext().getSessionMap();
		mapaDaSessao.put("curso", new Curso());
	}
	
	@SuppressWarnings("unchecked")
	public void pesquisar() {
		try {
			Curso curso = (Curso)JsfHelper.getSessionAttribute("curso");
			Session hSession = HibernateHelper.openSession();
			curso.setLsCurso(hSession.createCriteria(Curso.class).list());
			JsfHelper.setSessionAttribute("curso", curso);
		} catch (Exception e) {
			JsfHelper.addErrorMessage(e.toString());
		}
	}
	
}