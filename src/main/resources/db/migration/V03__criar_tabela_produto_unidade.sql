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
qtd_encomenda BIGINT,
preco_venda DECIMAL(10, 2) NOT NULL,
desconto1 DECIMAL(10, 2),
desconto2 DECIMAL(10, 2),
desconto3 DECIMAL(10, 2),
desconto4 DECIMAL(10, 2),
codigo_unidade BIGINT NOT NULL,
codigo_fabricante BIGINT NOT NULL,
codigo_subcategoria BIGINT NOT NULL,
codigo_fornecedor BIGINT NOT NULL,
PRIMARY KEY(codigo),
CONSTRAINT fk_unidade_produto
  FOREIGN KEY(codigo_unidade) REFERENCES unidade(codigo),
CONSTRAINT fk_fabricante_produto
  FOREIGN KEY(codigo_fabricante) REFERENCES fabricante(codigo),
CONSTRAINT fk_subcategoria_produto
  FOREIGN KEY(codigo_subcategoria) REFERENCES subcategoria(codigo),
CONSTRAINT fk_fornecedor_produto
  FOREIGN KEY(codigo_fornecedor) REFERENCES fornecedor(codigo)

);