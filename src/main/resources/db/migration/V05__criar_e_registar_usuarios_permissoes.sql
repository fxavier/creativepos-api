CREATE TABLE usuario (
	codigo BIGSERIAL,
    nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(50),
	apelido VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	login VARCHAR(150),
	senha VARCHAR(150) NOT NULL,
	telefone VARCHAR(255),
	activo BOOLEAN DEFAULT true,
	PRIMARY KEY(codigo)
);

CREATE TABLE permissao (
	codigo BIGSERIAL,
	descricao VARCHAR(50) NOT NULL,
	PRIMARY KEY(codigo)
);

CREATE TABLE usuario_permissao (
	codigo_usuario BIGINT NOT NULL,
	codigo_permissao BIGINT NOT NULL,
	PRIMARY KEY (codigo_usuario, codigo_permissao),
	CONSTRAINT fk_usuario_permissao
	  FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	CONSTRAINT fk_permissao_usuario
	  FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
);

INSERT INTO usuario (codigo, nome,sobrenome,apelido,email,login,senha,telefone) values (1, 'Administrador','','Admin', 'admin@creativepos.com','admin', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.','');


INSERT INTO permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR_CATEGORIA');
INSERT INTO permissao (codigo, descricao) values (2, 'ROLE_PESQUISAR_CATEGORIA');

INSERT INTO permissao (codigo, descricao) values (3, 'ROLE_CADASTRAR_BANCO');
INSERT INTO permissao (codigo, descricao) values (4, 'ROLE_REMOVER_BANCO');
INSERT INTO permissao (codigo, descricao) values (5, 'ROLE_PESQUISAR_BANCO');

INSERT INTO permissao (codigo, descricao) values (6, 'ROLE_CADASTRAR_PRODUTO');
INSERT INTO permissao (codigo, descricao) values (7, 'ROLE_REMOVER_PRODUTO');
INSERT INTO permissao (codigo, descricao) values (8, 'ROLE_PESQUISAR_PRODUTO');

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 8);
