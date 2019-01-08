CREATE TABLE pais(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(50) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE banco(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(30) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE moeda(
codigo BIGSERIAL,
designacao VARCHAR(20) NOT NULL,
sigla VARCHAR(10) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE fornecedor(
codigo BIGSERIAL NOT NULL,
numero_interno BIGINT,
nome VARCHAR(50) NOT NULL,
abreviatura VARCHAR(10),
morada TEXT NOT NULL,
cx_postal VARCHAR(20),
telefone VARCHAR(30),
telemovel VARCHAR(30),
fax VARCHAR(30),
email VARCHAR(50),
website VARCHAR(50),
numero_contribuinte BIGINT,
representante VARCHAR(50) NOT NULL,
limite_credito NUMERIC,
saldo_cnt_corrente NUMERIC,
observacaoes TEXT,
bilhete_identidade VARCHAR(20),
data_emissao DATE,
local_emissao VARCHAR(30),
passaporte VARCHAR(50),
conta VARCHAR(50),
nib VARCHAR(100),
iban VARCHAR(100),
swift VARCHAR(100),
activo BOOLEAN DEFAULT true,
codigo_pais BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_pais_fornecedor
  FOREIGN KEY(codigo_pais) REFERENCES pais(codigo)
);

CREATE TABLE cliente(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(50) NOT NULL,
abreviatura VARCHAR(20),
morada TEXT NOT NULL,
cx_postal VARCHAR(20),
telefone VARCHAR(30),
telemovel VARCHAR(30),
fax VARCHAR(30),
email VARCHAR(50),
observacaoes TEXT,
activo BOOLEAN DEFAULT true,
codigo_pais BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_pais_cliente
  FOREIGN KEY(codigo_pais) REFERENCES pais(codigo)
);