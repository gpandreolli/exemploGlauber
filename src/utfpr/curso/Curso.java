package utfpr.curso;

import javax.faces.bean.ManagedBean;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
@Entity
@Table
public class Curso {
	
	@Id
	private Integer id ;
	
	
	private String nome ;	
	
	
	
	public Curso() {
	}

	public Curso(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
	

}
