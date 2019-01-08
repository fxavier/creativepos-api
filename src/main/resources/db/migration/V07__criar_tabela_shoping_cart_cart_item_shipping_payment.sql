CREATE TABLE cart(
codigo BIGSERIAL NOT NULL,
data_criacao DATE NOT NULL,
valor_total NUMERIC(10, 2) NOT NULL,
codigo_usuario BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_cart_usuario
  FOREIGN KEY(codigo_usuario) REFERENCES usuario(codigo)
);

CREATE TABLE cart_item(
codigo BIGSERIAL NOT NULL,
quantidade INTEGER NOT NULL,
valor_unitario NUMERIC(10, 2) NOT NULL,
codigo_produto BIGINT,
codigo_cart BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_cart_cart_item
  FOREIGN KEY(codigo_cart) REFERENCES cart(codigo),
CONSTRAINT fk_cart_item_produto
  FOREIGN KEY(codigo_produto) REFERENCES produto(codigo)
);

CREATE TABLE billing_address(
codigo BIGSERIAL NOT NULL,
nome VARCHAR(100) NOT NULL,
sobrenome VARCHAR(100),
apelido VARCHAR(100) NOT NULL,
empresa VARCHAR(100),
email VARCHAR(255) NOT NULL,
telefone VARCHAR(100) NOT NULL,
codigo_pais BIGINT,
provincia VARCHAR(100),
cidade VARCHAR(100) NOT NULL,
caixa_postal VARCHAR(100),
endereco TEXT,
codigo_usuario BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_billing_usuario
  FOREIGN KEY(codigo_usuario) REFERENCES usuario(codigo)
);

CREATE TABLE tipo_pagamento(
codigo SERIAL,
designacao VARCHAR(100),
PRIMARY KEY(codigo)
);

CREATE TABLE pagamento(
codigo BIGSERIAL,
codigo_tipo_pagamento INTEGER,
numero_transacao BIGINT,
codigo_pedido BIGINT,
PRIMARY KEY(codigo),
CONSTRAINT fk_pagamento_pedido
  FOREIGN KEY(codigo_tipo_pagamento) REFERENCES tipo_pagamento(codigo),
CONSTRAINT fk_pedido_pagamento
  FOREIGN KEY(codigo_pedido) REFERENCES pedido_venda(codigo)
);