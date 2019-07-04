package utfpr.curso;

import java.util.ArrayList;
import utfpr.util.HibernateHelper;
import utfpr.util.JsfHelper;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class CursoBo {
	
	public void salvar() {
		Curso curso = (Curso)JsfHelper.getSessionAttribute("curso");
		try {
			HibernateHelper.save(curso);
			JsfHelper.addMessage("Registro Salvo");
			
		}catch(Exception e) {
			JsfHelper.addErrorMessage("Erro ao salvar o curso");
		}
	}
	
	public List<Curso> getListaCursos(String busca){
		List<Curso> lsCurso = new ArrayList<Curso>();
		lsCurso.add(new Curso(1, "Sistema de Informação"));
		lsCurso.add(new Curso(2, "Contabilidade"));
		lsCurso.add(new Curso(3, "Letras"));
		lsCurso.add(new Curso(4, "Eng. Produção"));
		lsCurso.add(new Curso(5, "Administração "));
		lsCurso.add(new Curso(6, "Ciencia da Computação"));
		lsCurso.add(new Curso(7, "Eng Ambiental"));
		
		
		if((busca != null) &&(!busca.equals(""))) {
			List<Curso> lsAux = new ArrayList<Curso>();
			
			for (Curso d: lsCurso){
				if (d.getNome().toUpperCase().contains(busca.toUpperCase())){
					lsAux.add(d);
				}
			}
			return lsAux;
			
		}else {
			return lsCurso;
		}			
	}


}
