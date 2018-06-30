package com.xavier.creativepos.api.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String referencia;
	
	@Column(name = "codigo_barras")
	private String codigoBarras;
	
	private String nome;
	
	@Column(name = "stock_actual")
	private Long stockActual;
	
	@Column(name = "stock_minimo")
	private Long stockMinimo;
	
	@Column(name = "stock_maximo")
	private Long stockMaximo;
	
	@Column(name = "pto_encomenda")
	private Long pontoEncomenda;
	
	@Column(name = "qtd_encomenda")
	private Long quantidadeEncomenda;
	
	@Column(name = "preco_venda")
	private BigDecimal precovenda;
	
	private BigDecimal desconto1;
	
	private BigDecimal desconto2;
	
	private BigDecimal desconto3;
	
	private BigDecimal desconto4;
	
	@ManyToOne
	@JoinColumn(name = "codigo_unidade")
	private Unidade unidade;
	
	@ManyToOne
	@JoinColumn(name = "codigo_fabricante")
	private Fabricante fabricante;
	
	@ManyToOne
	@JoinColumn(name = "codigo_subcategoria")
	private Subcategoria subcategoria;
	
	@ManyToOne
	@JoinColumn(name = "codigo_fornecedor")
	private Fornecedor fornecedor;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public Long getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(Long stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public Long getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(Long stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public Long getPontoEncomenda() {
		return pontoEncomenda;
	}

	public void setPontoEncomenda(Long pontoEncomenda) {
		this.pontoEncomenda = pontoEncomenda;
	}

	public Long getQuantidadeEncomenda() {
		return quantidadeEncomenda;
	}

	public void setQuantidadeEncomenda(Long quantidadeEncomenda) {
		this.quantidadeEncomenda = quantidadeEncomenda;
	}

	public BigDecimal getPrecovenda() {
		return precovenda;
	}

	public void setPrecovenda(BigDecimal precovenda) {
		this.precovenda = precovenda;
	}

	public BigDecimal getDesconto1() {
		return desconto1;
	}

	public void setDesconto1(BigDecimal desconto1) {
		this.desconto1 = desconto1;
	}

	public BigDecimal getDesconto2() {
		return desconto2;
	}

	public void setDesconto2(BigDecimal desconto2) {
		this.desconto2 = desconto2;
	}

	public BigDecimal getDesconto3() {
		return desconto3;
	}

	public void setDesconto3(BigDecimal desconto3) {
		this.desconto3 = desconto3;
	}

	public BigDecimal getDesconto4() {
		return desconto4;
	}

	public void setDesconto4(BigDecimal desconto4) {
		this.desconto4 = desconto4;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	

}
