CREATE TABLE categoria(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(100) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE subcategoria(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(100) NOT NULL,
codigo_categoria BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_categoria_subcategoria
  FOREIGN KEY(codigo_categoria) REFERENCES categoria(codigo)
);

CREATE TABLE cor(
codigo SERIAL NOT NULL,
nome VARCHAR(100),
hexadesignacao VARCHAR(100),
PRIMARY KEY(codigo)
);

CREATE TABLE imagem(
codigo BIGSERIAL NOT NULL,
imageurl VARCHAR(500),
PRIMARY KEY(codigo)
);

CREATE TABLE tamanho(
codigo SERIAL NOT NULL,
size VARCHAR(20),
PRIMARY KEY(codigo)
);

CREATE TABLE marca(
codigo SERIAL,
designacao VARCHAR(100),
PRIMARY KEY(codigo)
);

CREATE TABLE endereco(
codigo SERIAL NOT NULL,
address_type VARCHAR(50),
address_line VARCHAR(50),
codigo_pais BIGINT,
cidade VARCHAR(50),
provincia VARCHAR(50),
PRIMARY KEY(codigo)
);