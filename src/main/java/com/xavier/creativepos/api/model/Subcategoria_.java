package com.xavier.creativepos.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Subcategoria.class)
public abstract class Subcategoria_ {

	public static volatile SingularAttribute<Subcategoria, Long> codigo;
	public static volatile SingularAttribute<Subcategoria, String> codigoInterno;
	public static volatile SingularAttribute<Subcategoria, Categoria> categoria;
	public static volatile SingularAttribute<Subcategoria, String> nome;

}

