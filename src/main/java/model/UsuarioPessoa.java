package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
@NamedQuery(name = "consultaTodos", query = "select u from UsuarioPessoa u"),
@NamedQuery(name = "buscaPorNome", query= "select u from UsuarioPessoa u where u.nome = :nome")
})
public class UsuarioPessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String login;
	private String senha;
	
	@OneToMany (mappedBy = "UsuarioPessoa")
	private List<TelefoneUser> telefoneUser; 
	
	public List<TelefoneUser> getTelefoneUser() {
		return telefoneUser;
	}
	
	public void setTelefoneUser(List<TelefoneUser> telefoneUser) {
		this.telefoneUser = telefoneUser;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "UsuarioPessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email
				+ ", login=" + login + ", senha=" + senha + "]";
	}
	
	
	
	

}
