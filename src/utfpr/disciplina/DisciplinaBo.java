package utfpr.disciplina;

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
public class DisciplinaBo {

	public void salvar() {
		Disciplina disciplina = (Disciplina )JsfHelper.getSessionAttribute("disciplina");
		try {
			HibernateHelper.save(disciplina);
			JsfHelper.addMessage("Registro salvo");
		} catch (Exception e) {
			JsfHelper.addErrorMessage("Erro ao salvar o registro "+e.toString());
		}
	}
	
	public void novo() {
		Map<String, Object> mapaDaSessao = FacesContext.getCurrentInstance().
				getExternalContext().getSessionMap();
		mapaDaSessao.put("disciplina", new Disciplina());
	}
	
	@SuppressWarnings("unchecked")
	public void pesquisar() {
		try {
			Disciplina disciplina = (Disciplina)JsfHelper.getSessionAttribute("disciplina");
			Session hSession = HibernateHelper.openSession();
			disciplina.setLsDisciplina(hSession.createCriteria(Disciplina.class).list());
			JsfHelper.setSessionAttribute("disciplina", disciplina);
		} catch (Exception e) {
			JsfHelper.addErrorMessage(e.toString());
		}
	}
	
}