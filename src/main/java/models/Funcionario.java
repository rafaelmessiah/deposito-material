package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Funcionario {

	@Id
	private long cpf;
	
	private String nome;
	
	private String cargo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="cpf_Funcionario" )
	private List<NotaFiscal> notasFiscais;
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public List<NotaFiscal> getNotasFiscais() {
		return notasFiscais;
	}
	public void setNotasFiscais(List<NotaFiscal> notasFiscais) {
		this.notasFiscais = notasFiscais;
	}
	
	
	
}
