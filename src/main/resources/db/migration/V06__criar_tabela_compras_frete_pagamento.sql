CREATE TABLE pedido_venda(
codigo BIGSERIAL NOT NULL,
data_compra DATE NOT NULL,
valor_desconto NUMERIC(10, 2),
valor_frete NUMERIC(10, 2),
valor_total NUMERIC(10, 2),
data_frete DATE,
status_compra VARCHAR(100),
codigo_endereco_frete BIGINT,
codigo_usuario BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_compra_endereco
  FOREIGN KEY(codigo_endereco_frete) REFERENCES endereco(codigo),
CONSTRAINT fk_compra_usuario
  FOREIGN KEY(codigo_usuario) REFERENCES usuario(codigo)
);

CREATE TABLE item_pedido(
codigo BIGSERIAL NOT NULL,
quantidade INTEGER NOT NULL,
valor_unitario NUMERIC(10, 2),
codigo_produto BIGINT,
codigo_pedido BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_item_pedido
  FOREIGN KEY(codigo_pedido) REFERENCES pedido_venda(codigo),
CONSTRAINT fk_item_produto
  FOREIGN KEY(codigo_produto) REFERENCES produto(codigo)
);