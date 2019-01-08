package com.xavier.creativepos.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, Long> codigo;
	public static volatile SingularAttribute<Produto, BigDecimal> largura;
	public static volatile SingularAttribute<Produto, BigDecimal> desconto;
	public static volatile SingularAttribute<Produto, BigDecimal> peso;
	public static volatile SingularAttribute<Produto, BigDecimal> outrasDespesas;
	public static volatile SingularAttribute<Produto, BigDecimal> precoCusto;
	public static volatile SingularAttribute<Produto, Categoria> categoria;
	public static volatile SingularAttribute<Produto, Long> rating;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, Unidade> unidade;
	public static volatile SingularAttribute<Produto, Long> stockMaximo;
	public static volatile SingularAttribute<Produto, BigDecimal> despesasAcessorias;
	public static volatile SingularAttribute<Produto, BigDecimal> volume;
	public static volatile SingularAttribute<Produto, Long> stockMinimo;
	public static volatile SingularAttribute<Produto, String> imgUrl;
	public static volatile SingularAttribute<Produto, BigDecimal> altura;
	public static volatile SingularAttribute<Produto, LocalDate> dataValidade;
	public static volatile SingularAttribute<Produto, Long> stockActual;
	public static volatile SingularAttribute<Produto, BigDecimal> comprimento;
	public static volatile SingularAttribute<Produto, Fornecedor> fornecedor;
	public static volatile SingularAttribute<Produto, String> codigoBarras;
	public static volatile SingularAttribute<Produto, String> referencia;
	public static volatile SingularAttribute<Produto, BigDecimal> precovenda;
	public static volatile SingularAttribute<Produto, BigDecimal> lucro;

}

