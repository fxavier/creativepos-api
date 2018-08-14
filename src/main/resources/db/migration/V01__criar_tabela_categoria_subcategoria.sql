CREATE TABLE categoria(
codigo BIGSERIAL NOT NULL,
codigo_interno VARCHAR(30),
nome VARCHAR(100) NOT NULL,
PRIMARY KEY(codigo)
);


INSERT INTO categoria(codigo_interno, nome) VALUES('ELD001', 'Electrodomesticos' );
INSERT INTO categoria(codigo_interno, nome) VALUES('ALM001', 'Produtos Alimentares' );
INSERT INTO categoria(codigo_interno, nome) VALUES('LIP001', 'Produtos de limpeza' );

