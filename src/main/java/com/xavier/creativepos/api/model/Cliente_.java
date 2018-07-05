package com.xavier.creativepos.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, String> bilheteIdentidade;
	public static volatile SingularAttribute<Cliente, String> telefone;
	public static volatile SingularAttribute<Cliente, String> nib;
	public static volatile SingularAttribute<Cliente, String> conta;
	public static volatile SingularAttribute<Cliente, LocalDate> dataEmissao;
	public static volatile SingularAttribute<Cliente, String> passaporte;
	public static volatile SingularAttribute<Cliente, String> numeroContribuinte;
	public static volatile SingularAttribute<Cliente, String> telemovel;
	public static volatile SingularAttribute<Cliente, String> fax;
	public static volatile SingularAttribute<Cliente, String> email;
	public static volatile SingularAttribute<Cliente, String> localEmissao;
	public static volatile SingularAttribute<Cliente, String> morada;
	public static volatile SingularAttribute<Cliente, String> swift;
	public static volatile SingularAttribute<Cliente, Long> codigo;
	public static volatile SingularAttribute<Cliente, String> website;
	public static volatile SingularAttribute<Cliente, String> abrevatura;
	public static volatile SingularAttribute<Cliente, BigDecimal> limiteCredito;
	public static volatile SingularAttribute<Cliente, Banco> banco;
	public static volatile SingularAttribute<Cliente, String> nome;
	public static volatile SingularAttribute<Cliente, String> caixaPostal;
	public static volatile SingularAttribute<Cliente, Pais> pais;
	public static volatile SingularAttribute<Cliente, String> observacoes;
	public static volatile SingularAttribute<Cliente, BigDecimal> saldoContaCorrente;
	public static volatile SingularAttribute<Cliente, String> iban;
	public static volatile SingularAttribute<Cliente, Boolean> activo;

}

