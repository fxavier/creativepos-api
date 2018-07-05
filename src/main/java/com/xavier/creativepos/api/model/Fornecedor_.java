package com.xavier.creativepos.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Fornecedor.class)
public abstract class Fornecedor_ {

	public static volatile SingularAttribute<Fornecedor, Long> numeroInterno;
	public static volatile SingularAttribute<Fornecedor, String> bilheteIdentidade;
	public static volatile SingularAttribute<Fornecedor, String> telefone;
	public static volatile SingularAttribute<Fornecedor, String> nib;
	public static volatile SingularAttribute<Fornecedor, String> conta;
	public static volatile SingularAttribute<Fornecedor, LocalDate> dataEmissao;
	public static volatile SingularAttribute<Fornecedor, String> passaporte;
	public static volatile SingularAttribute<Fornecedor, String> numeroContribuinte;
	public static volatile SingularAttribute<Fornecedor, String> telemovel;
	public static volatile SingularAttribute<Fornecedor, String> fax;
	public static volatile SingularAttribute<Fornecedor, String> email;
	public static volatile SingularAttribute<Fornecedor, String> localEmissao;
	public static volatile SingularAttribute<Fornecedor, String> morada;
	public static volatile SingularAttribute<Fornecedor, String> swift;
	public static volatile SingularAttribute<Fornecedor, Long> codigo;
	public static volatile SingularAttribute<Fornecedor, String> website;
	public static volatile SingularAttribute<Fornecedor, String> abrevatura;
	public static volatile SingularAttribute<Fornecedor, BigDecimal> limiteCredito;
	public static volatile SingularAttribute<Fornecedor, Banco> banco;
	public static volatile SingularAttribute<Fornecedor, String> nome;
	public static volatile SingularAttribute<Fornecedor, String> caixaPostal;
	public static volatile SingularAttribute<Fornecedor, Pais> pais;
	public static volatile SingularAttribute<Fornecedor, String> observacoes;
	public static volatile SingularAttribute<Fornecedor, Moeda> moeda;
	public static volatile SingularAttribute<Fornecedor, String> representante;
	public static volatile SingularAttribute<Fornecedor, BigDecimal> saldoContaCorrente;
	public static volatile SingularAttribute<Fornecedor, String> iban;
	public static volatile SingularAttribute<Fornecedor, Boolean> activo;

}

