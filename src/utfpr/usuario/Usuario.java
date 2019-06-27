package utfpr.usuario;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table
public class Usuario {
	
	@Id
	private String userId;
	
	private String nome;
	
	private String senha;
	
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
			this.userId = userId;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
