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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String referencia;
	
	@Column(name = "codigo_barras")
	private String codigoBarras;
	
	@NotNull
	private String nome;
	
	private BigDecimal peso;
	
	private BigDecimal largura;
	
	private BigDecimal altura;
	
	private BigDecimal comprimento;
	
	private BigDecimal volume;
	
	@Column(name = "stock_actual")
	private Long stockActual;
	
	@Column(name = "stock_minimo")
	private Long stockMinimo;
	
	@Column(name = "stock_maximo")
	private Long stockMaximo;
	
	@Column(name = "preco_custo")
	private BigDecimal precoCusto;

	@Column(name = "despesas_acessorias")
	private BigDecimal despesasAcessorias;
	
	@Column(name = "outras_despesas")
	private BigDecimal outrasDespesas;
	
	@NotNull
	@Column(name = "preco_venda")
	private BigDecimal precovenda;
	
	private BigDecimal desconto;
	
	@Column(name = "lucro")
	private BigDecimal lucro;
	
	@Column(name = "data_validade")
	private LocalDate dataValidade;
	
	private Long rating;
	
	@Column(name = "img_url")
	private String imgUrl;
	
	
	@ManyToOne
	@JoinColumn(name = "codigo_unidade")
	private Unidade unidade;
	
	
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

	
	public BigDecimal getPrecovenda() {
		return precovenda;
	}

	public void setPrecovenda(BigDecimal precovenda) {
		this.precovenda = precovenda;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getLargura() {
		return largura;
	}

	public void setLargura(BigDecimal largura) {
		this.largura = largura;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public BigDecimal getComprimento() {
		return comprimento;
	}

	public void setComprimento(BigDecimal comprimento) {
		this.comprimento = comprimento;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public BigDecimal getDespesasAcessorias() {
		return despesasAcessorias;
	}

	public void setDespesasAcessorias(BigDecimal despesasAcessorias) {
		this.despesasAcessorias = despesasAcessorias;
	}

	public BigDecimal getOutrasDespesas() {
		return outrasDespesas;
	}

	public void setOutrasDespesas(BigDecimal outrasDespesas) {
		this.outrasDespesas = outrasDespesas;
	}

	public BigDecimal getLucro() {
		return lucro;
	}

	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	
	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
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
