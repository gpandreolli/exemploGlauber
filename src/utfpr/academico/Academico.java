package utfpr.academico;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import java.util.ArrayList;

import utfpr.curso.Curso;
import utfpr.disciplina.Disciplina;

@ManagedBean
@SessionScoped
public class Academico {
	
	private String ra ;
	private String nome ;
	private Curso curso = new Curso();
	private String sexo;
	public String observacao;
	private Disciplina disciplina = new Disciplina();
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	private List<Disciplina> lsDisciplina = new ArrayList<Disciplina>();
	
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	private List<Curso> lsCurso = new ArrayList<Curso>();
	
	//public Academico() {
//	//	lsDisciplina.add(new Disciplina(1, "Banco de Dados I", "Sql Basico"));
	////	lsDisciplina.add(new Disciplina(2, "Banco de Dados II", "Sql Avançado"));
	//}
	
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public List<Disciplina> getLsDisciplina() {
		return lsDisciplina;
	}
	public void setLsDisciplina(List<Disciplina> lsDisciplina) {
		this.lsDisciplina = lsDisciplina;
	}

}
