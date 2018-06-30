CREATE TABLE categoria(
codigo BIGSERIAL NOT NULL,
codigo_interno VARCHAR(30),
nome VARCHAR(100) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE subcategoria(
codigo BIGSERIAL NOT NULL,
codigo_interno VARCHAR(50),
nome VARCHAR(100) NOT NULL,
codigo_categoria BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_categoria_subcategoria
  FOREIGN KEY(codigo_categoria) REFERENCES categoria(codigo)
);

INSERT INTO categoria VALUES(1,'ELD001', 'Electrodomesticos' );
INSERT INTO categoria VALUES(2,'ALM001', 'Produtos Alimentares' );
INSERT INTO categoria VALUES(3,'LIP001', 'Produtos de limpeza' );

INSERT INTO subcategoria VALUES(1,'ELD001GLR001', 'Geleira', 1);
INSERT INTO subcategoria VALUES(2,'ELD001INF001', 'Informatica', 1);
INSERT INTO subcategoria VALUES(3,'ELD001ENT001', 'Televisores', 1);