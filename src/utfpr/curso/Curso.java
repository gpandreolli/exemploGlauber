package utfpr.curso;

import javax.faces.bean.ManagedBean;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
@Entity
@Table
public class Curso {

	@Id
	private Integer cursoId;
	
	private String nome;
	
	@Transient
	private List<Curso> lsCurso = new ArrayList<Curso>();

	public Integer getCursoId() {
		return cursoId;
	}

	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getLsCurso() {
		return lsCurso;
	}

	public void setLsCurso(List<Curso> lsCurso) {
		this.lsCurso = lsCurso;
	}
}

 