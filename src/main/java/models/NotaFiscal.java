package models;

import java.util.Calendar;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
public class NotaFiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long numero;

	private int quantidadeComprada;

	private Double valorCompra;

	private String fornecedor;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCompra;
	
	@ManyToOne
	@JoinColumn(name = "cpf_Funcionario")
	@Fetch(FetchMode.JOIN)
	private Funcionario funcionario;

	// Contrutores
	public NotaFiscal() {
	}

	//Contrutor sem funcionario
	public NotaFiscal(int quantidadeComprada, Double valorCompra, String fornecedor, Calendar dataCompra) {
		this.quantidadeComprada = quantidadeComprada;
		this.valorCompra = valorCompra;
		this.fornecedor = fornecedor;
		this.dataCompra = dataCompra;
	}
	
	//Com funcionario
	public NotaFiscal(int quantidadeComprada, Double valorCompra, String fornecedor, Calendar dataCompra, Funcionario funcionario) {
		this.quantidadeComprada = quantidadeComprada;
		this.valorCompra = valorCompra;
		this.fornecedor = fornecedor;
		this.dataCompra = dataCompra;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public int getQuantidadeComprada() {
		return quantidadeComprada;
	}

	public void setQuantidadeComprada(int quantidadeComprada) {
		this.quantidadeComprada = quantidadeComprada;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Calendar getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}

}
