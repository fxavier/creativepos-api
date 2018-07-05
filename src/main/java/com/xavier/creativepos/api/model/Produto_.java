package com.xavier.creativepos.api.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, Long> codigo;
	public static volatile SingularAttribute<Produto, Long> quantidadeEncomenda;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, Unidade> unidade;
	public static volatile SingularAttribute<Produto, Long> stockMaximo;
	public static volatile SingularAttribute<Produto, Long> pontoEncomenda;
	public static volatile SingularAttribute<Produto, Long> stockMinimo;
	public static volatile SingularAttribute<Produto, BigDecimal> desconto3;
	public static volatile SingularAttribute<Produto, Subcategoria> subcategoria;
	public static volatile SingularAttribute<Produto, Long> stockActual;
	public static volatile SingularAttribute<Produto, BigDecimal> desconto4;
	public static volatile SingularAttribute<Produto, BigDecimal> desconto1;
	public static volatile SingularAttribute<Produto, BigDecimal> desconto2;
	public static volatile SingularAttribute<Produto, Fabricante> fabricante;
	public static volatile SingularAttribute<Produto, Fornecedor> fornecedor;
	public static volatile SingularAttribute<Produto, String> codigoBarras;
	public static volatile SingularAttribute<Produto, String> referencia;
	public static volatile SingularAttribute<Produto, BigDecimal> precovenda;

}
