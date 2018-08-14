package com.xavier.creativepos.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "numero_interno")
	private Long numeroInterno;
	
	private String nome;
	
	private String abreviatura;
	
	private String morada;
	
	@Column(name = "cx_postal")
	private String caixaPostal;
	
	private String telefone;
	
	private String telemovel;
	
	private String fax;
	
	private String email;
	
	private String website;
	
	@Column(name = "numero_contribuinte")
	private String numeroContribuinte;
	
	private String representante;
	
	@Column(name = "limite_credito")
	private BigDecimal limiteCredito;
	
	@Column(name = "saldo_cnt_corrente")
	private BigDecimal saldoContaCorrente;
	
	@Column(name = "observacaoes")
	private String observacoes;
	
	@Column(name = "bilhete_identidade")
	private String bilheteIdentidade;
	
	@Column(name = "data_emissao")
	private LocalDate dataEmissao;
	
	@Column(name = "local_emissao")
	private String localEmissao;
	
	private String passaporte;
	
	private String conta;
	
	private String nib;
	
	private String iban;
	
	private String swift;
	
	private Boolean activo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_pais")
	private Pais pais;
	
	@ManyToOne
	@JoinColumn(name = "codigo_banco")
	private Banco banco;
	
	@ManyToOne
	@JoinColumn(name = "codigo_moeda")
	private Moeda moeda;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(Long numeroInterno) {
		this.numeroInterno = numeroInterno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public String getCaixaPostal() {
		return caixaPostal;
	}

	public void setCaixaPostal(String caixaPostal) {
		this.caixaPostal = caixaPostal;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelemovel() {
		return telemovel;
	}

	public void setTelemovel(String telemovel) {
		this.telemovel = telemovel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getNumeroContribuinte() {
		return numeroContribuinte;
	}

	public void setNumeroContribuinte(String numeroContribuinte) {
		this.numeroContribuinte = numeroContribuinte;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public BigDecimal getSaldoContaCorrente() {
		return saldoContaCorrente;
	}

	public void setSaldoContaCorrente(BigDecimal saldoContaCorrente) {
		this.saldoContaCorrente = saldoContaCorrente;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getBilheteIdentidade() {
		return bilheteIdentidade;
	}

	public void setBilheteIdentidade(String bilheteIdentidade) {
		this.bilheteIdentidade = bilheteIdentidade;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getLocalEmissao() {
		return localEmissao;
	}

	public void setLocalEmissao(String localEmissao) {
		this.localEmissao = localEmissao;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getNib() {
		return nib;
	}

	public void setNib(String nib) {
		this.nib = nib;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
