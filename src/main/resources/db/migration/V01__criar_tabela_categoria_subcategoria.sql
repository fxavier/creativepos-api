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

INSERT INTO categoria(codigo_interno, nome) VALUES('ELD001', 'Electrodomesticos' );
INSERT INTO categoria(codigo_interno, nome) VALUES('ALM001', 'Produtos Alimentares' );
INSERT INTO categoria(codigo_interno, nome) VALUES('LIP001', 'Produtos de limpeza' );

INSERT INTO subcategoria(codigo_interno, nome, codigo_categoria) VALUES('ELD001GLR001', 'Geleira', 1);
INSERT INTO subcategoria(codigo_interno, nome, codigo_categoria) VALUES('ELD001INF001', 'Informatica', 1);
INSERT INTO subcategoria(codigo_interno, nome, codigo_categoria) VALUES('ELD001ENT001', 'Televisores', 1);