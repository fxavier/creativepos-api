CREATE TABLE unidade(
codigo BIGSERIAL NOT NULL,
designacao VARCHAR(20) NOT NULL,
sigla VARCHAR(10) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE fabricante(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(50) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE produto(
codigo BIGSERIAL NOT NULL,
referencia VARCHAR(20) NOT NULL,
codigo_barras VARCHAR(50),
nome VARCHAR(50) NOT NULL,
stock_actual BIGINT NOT NULL,
stock_minimo BIGINT NOT NULL,
stock_maximo BIGINT NOT NULL,
pto_encomenda BIGINT,
preco_custo DECIMAL(10, 2),
preco_venda DECIMAL(10, 2) NOT NULL,
desconto DECIMAL(10, 2) NOT NULL,
data_validade DATE NOT NULL,
codigo_unidade BIGINT NOT NULL,
codigo_fabricante BIGINT NOT NULL,
codigo_categoria BIGINT NOT NULL,
codigo_fornecedor BIGINT NOT NULL,
activo BOOLEAN DEFAULT true,
PRIMARY KEY(codigo),
CONSTRAINT fk_unidade_produto
  FOREIGN KEY(codigo_unidade) REFERENCES unidade(codigo),
CONSTRAINT fk_fabricante_produto
  FOREIGN KEY(codigo_fabricante) REFERENCES fabricante(codigo),
CONSTRAINT fk_categoria_produto
  FOREIGN KEY(codigo_categoria) REFERENCES categoria(codigo),
CONSTRAINT fk_fornecedor_produto
  FOREIGN KEY(codigo_fornecedor) REFERENCES fornecedor(codigo)

);

CREATE TABLE armazem(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(100) NOT NULL,
stock_minimo BIGINT NOT NULL,
stock_maximo BIGINT NOT NULL,
codigo_produto BIGINT NOT NULL,
activo BOOLEAN DEFAULT true,
PRIMARY KEY(codigo),
CONSTRAINT fk_armazem_produto
  FOREIGN KEY(codigo_produto) REFERENCES produto(codigo)
);