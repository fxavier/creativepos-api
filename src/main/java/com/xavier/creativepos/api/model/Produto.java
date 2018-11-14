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
	
	@Column(name = "preco_venda")
	private BigDecimal precovenda;
	
	private BigDecimal desconto;
	
	private BigDecimal margem_bruta;
	
	private LocalDate data_validade;
	
	
	@ManyToOne
	@JoinColumn(name = "codigo_unidade")
	private Unidade unidade;
	
	@ManyToOne
	@JoinColumn(name = "codigo_fabricante")
	private Fabricante fabricante;
	
	@ManyToOne
	@JoinColumn(name = "codigo_categoria")
	private Categoria categoria;
	
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

	public BigDecimal getPrecovenda() {
		return precovenda;
	}

	public void setPrecovenda(BigDecimal precovenda) {
		this.precovenda = precovenda;
	}

	

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getMargem_bruta() {
		return margem_bruta;
	}

	public void setMargem_bruta(BigDecimal margem_bruta) {
		this.margem_bruta = margem_bruta;
	}

	public LocalDate getData_validade() {
		return data_validade;
	}

	public void setData_validade(LocalDate data_validade) {
		this.data_validade = data_validade;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
