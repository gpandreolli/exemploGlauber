package utfpr.disciplina;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import java.util.ArrayList;


@ManagedBean
@SessionScoped
public class DisciplinaBo {
	
	public List<Disciplina> getListaDisciplinas(String busca){
		List<Disciplina> lsDisciplina = new ArrayList<Disciplina>();
		lsDisciplina.add(new Disciplina(1, "Banco de Dados I", "Sql Basico"));
		lsDisciplina.add(new Disciplina(2, "Banco de Dados II", "Sql Avançado"));
		lsDisciplina.add(new Disciplina(3, "Prog Web", "Angular 6"));
		lsDisciplina.add(new Disciplina(4, "Ingles Técnico", "Google Translate"));
		
		return lsDisciplina;
		
	}
	

}
