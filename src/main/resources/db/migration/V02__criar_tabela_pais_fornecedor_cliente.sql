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
limite_credito DECIMAL(10, 2) NOT NULL,
saldo_cnt_corrente DECIMAL(10, 2) NOT NULL,
observacaoes TEXT,
bilhete_identidade VARCHAR(20),
data_emissao DATE,
local_emissao VARCHAR(30),
passaporte VARCHAR(50),
conta VARCHAR(50) NOT NULL,
nib VARCHAR(100) NOT NULL,
iban VARCHAR(100),
swift VARCHAR(100),
activo BOOLEAN DEFAULT true,
codigo_pais BIGINT,
codigo_banco BIGINT,
codigo_moeda BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_pais_fornecedor
  FOREIGN KEY(codigo_pais) REFERENCES pais(codigo),
CONSTRAINT fk_banco_fornecedor
  FOREIGN KEY(codigo_banco) REFERENCES banco(codigo),
CONSTRAINT fk_moeda_fornecedor
  FOREIGN KEY(codigo_moeda) REFERENCES moeda(codigo)
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
website VARCHAR(50),
numero_contribuinte BIGINT,
limite_credito DECIMAL(10, 2) NOT NULL,
saldo_cnt_corrente DECIMAL(10, 2) NOT NULL,
observacaoes TEXT,
bilhete_identidade VARCHAR(20),
data_emissao DATE,
local_emissao VARCHAR(30),
passaporte VARCHAR(50),
conta VARCHAR(50) NOT NULL,
nib VARCHAR(100) NOT NULL,
iban VARCHAR(100),
swift VARCHAR(100),
activo BOOLEAN DEFAULT true,
codigo_pais BIGINT,
codigo_banco BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_pais_cliente
  FOREIGN KEY(codigo_pais) REFERENCES pais(codigo),
CONSTRAINT fk_banco_cliente
  FOREIGN KEY(codigo_banco) REFERENCES banco(codigo)

);