package com.xavier.creativepos.api.repository.projection;

import java.math.BigDecimal;

public class ResumoProduto {
	
	private String referencia;
	
	private String codigoBarras;
	
	private String nome;
	
	private Long stockActual;
	
	private BigDecimal precoVenda;
	
	private String unidade;

	public ResumoProduto(String referencia, String codigoBarras, String nome, Long stockActual, BigDecimal precoVenda,
			String unidade) {
		this.referencia = referencia;
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.stockActual = stockActual;
		this.precoVenda = precoVenda;
		this.unidade = unidade;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getStockActual() {
		return stockActual;
	}

	public void setStockActual(Long stockActual) {
		this.stockActual = stockActual;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	
	
	

}
