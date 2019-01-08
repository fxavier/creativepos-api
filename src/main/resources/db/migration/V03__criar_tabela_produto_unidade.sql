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
peso NUMERIC(5, 2),
stock_actual BIGINT DEFAULT 0,
preco_custo NUMERIC(10, 2),
despesas_acessorias NUMERIC(10, 2),
outras_despesas NUMERIC(10, 2),
custo_total NUMERIC(10, 2),
preco_venda_actual NUMERIC(10, 2) NOT NULL,
preco_venda_antigo NUMERIC(10, 2) DEFAULT 0,
desconto NUMERIC(10, 2) DEFAULT 0,
data_validade DATE,
codigo_subcategoria BIGINT,
codigo_fornecedor BIGINT,
codigo_tamanho BIGINT,
codigo_cor BIGINT,
codigo_imagem BIGINT,
activo BOOLEAN DEFAULT true,
PRIMARY KEY(codigo),
CONSTRAINT fk_subcategoria_produto
  FOREIGN KEY(codigo_subcategoria) REFERENCES subcategoria(codigo),
CONSTRAINT fk_fornecedor_produto
  FOREIGN KEY(codigo_fornecedor) REFERENCES fornecedor(codigo),
CONSTRAINT fk_tamanho_produto
  FOREIGN KEY(codigo_tamanho) REFERENCES tamanho(codigo),
CONSTRAINT fk_cor_produto
  FOREIGN KEY(codigo_cor) REFERENCES cor(codigo),
CONSTRAINT fk_imagem_produto
  FOREIGN KEY(codigo_imagem) REFERENCES imagem(codigo)
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