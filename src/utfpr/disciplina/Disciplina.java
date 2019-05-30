package utfpr.disciplina;

public class Disciplina {
	
	private Integer id;
	private String nome;
	private String ementa;
	
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
	
	

}
