CREATE TABLE unidade(
codigo BIGSERIAL NOT NULL,
designacao VARCHAR(20) NOT NULL,
sigla VARCHAR(10) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE produto(
codigo BIGSERIAL NOT NULL,
referencia VARCHAR(20) NOT NULL,
codigo_barras VARCHAR(50),
nome VARCHAR(50) NOT NULL,
peso BIGINT,
largura BIGINT,
altura BIGINT,
comprimento BIGINT,
volume BIGINT,
stock_actual BIGINT DEFAULT 0,
stock_minimo BIGINT DEFAULT 0,
stock_maximo BIGINT DEFAULT 0,
preco_custo DECIMAL(10, 2),
despesas_acessorias DECIMAL(10, 2),
outras_despesas DECIMAL(10, 2),
custo_total DECIMAL(10, 2),
preco_venda DECIMAL(10, 2) NOT NULL,
lucro DECIMAL(10, 2),
desconto DECIMAL(10, 2) NOT NULL,
data_validade DATE,
codigo_unidade BIGINT NOT NULL,
codigo_categoria BIGINT NOT NULL,
codigo_fornecedor BIGINT NOT NULL,
activo BOOLEAN DEFAULT true,
PRIMARY KEY(codigo),
CONSTRAINT fk_unidade_produto
  FOREIGN KEY(codigo_unidade) REFERENCES unidade(codigo),
CONSTRAINT fk_categoria_produto
  FOREIGN KEY(codigo_categoria) REFERENCES categoria(codigo),
CONSTRAINT fk_fornecedor_produto
  FOREIGN KEY(codigo_fornecedor) REFERENCES fornecedor(codigo)

);

CREATE TABLE armazem(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(100) NOT NULL,
capacidade BIGINT DEFAULT 0,
stock_actual BIGINT DEFAULT 0,
stock_minimo BIGINT DEFAULT 0,
stock_maximo BIGINT DEFAULT 0,
codigo_produto BIGINT NOT NULL,
activo BOOLEAN DEFAULT true,
PRIMARY KEY(codigo),
CONSTRAINT fk_armazem_produto
  FOREIGN KEY(codigo_produto) REFERENCES produto(codigo)
);