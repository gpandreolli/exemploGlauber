package utfpr.disciplina;

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
public class Disciplina {
	
	@Id
	private Integer id;
	
	private String nome;
	
	private String ementa;
	
	@Transient
	private List<Disciplina> lsDisciplina = new ArrayList<Disciplina>();
	
	
	public Disciplina() {
		
	}
	public Disciplina (Integer id, String nome, String ementa) {
		this.id =id;
		this.nome = nome;
		this.ementa = ementa;		
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
		
	}
	
	public String getEmenta() {
		return ementa;
		
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	
	public List<Disciplina> getLsDisciplina() {
		return lsDisciplina;
	}

	public void setLsDisciplina(List<Disciplina> lsDisciplina) {
		this.lsDisciplina = lsDisciplina;
	}
	
	

}
