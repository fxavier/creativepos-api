CREATE TABLE dossier_interno(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(100) NOT NULL,
referencia VARCHAR(50),
PRIMARY KEY(codigo)
);

CREATE TABLE documento_facturacao(
codigo BIGSERIAL NOT NULL,
designacao VARCHAR(50) NOT NULL,
numero_seq BIGINT NOT NULL DEFAULT 0,
ano_documento DATE NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE movimento_stock(
codigo BIGSERIAL NOT NULL,
data_movimento DATE NOT NULL,
codigo_produto BIGINT NOT NULL,
quantidade BIGINT NOT NULL,
valor DECIMAL(10, 2) NOT NULL,
observacao TEXT,
codigo_dossier BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_movimento_produto
  FOREIGN KEY(codigo_produto) REFERENCES produto(codigo),
CONSTRAINT fk_dossier_movimento
  FOREIGN KEY(codigo_dossier) REFERENCES dossier_interno(codigo)
);