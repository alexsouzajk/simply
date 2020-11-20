DROP DATABASE simply;

CREATE DATABASE simply;
USE simply;

CREATE TABLE bancos(
codigo INT PRIMARY KEY,
banco VARCHAR(100)
)

CREATE TABLE endereco(
	id INT IDENTITY PRIMARY KEY,
	logradouro VARCHAR(100),
	bairro VARCHAR(100),
	UF VARCHAR(2),
	numero int,
	complemento VARCHAR(100)
)

CREATE TABLE cliente(
	id INT IDENTITY PRIMARY KEY,
	cnpj_cpf VARCHAR(15),
	id_endereco INT,
	nome VARCHAR(255),
	data_nascimento DATE,
	FOREIGN KEY (id_endereco) REFERENCES endereco(id)
)

CREATE TABLE conta_cliente(
	id INT IDENTITY PRIMARY KEY,
	cod_banco INT,
	id_cliente INT,
	cod_agencia varchar(4),
	cod_conta varchar(20),
	principal bit,
	FOREIGN KEY (id_cliente) REFERENCES cliente(id),
	FOREIGN KEY (cod_banco) REFERENCES bancos(codigo)
)

CREATE TABLE conta_cliente_simply(
	id INT IDENTITY PRIMARY KEY,
	cod_banco INT,
	id_cliente INT,
	cod_agencia varchar(4),
	cod_conta varchar(20),
	saldo MONEY,
	data_saldo DATE,
	FOREIGN KEY (id_cliente) REFERENCES cliente(id),
	FOREIGN KEY (cod_banco) REFERENCES bancos(codigo)
)

CREATE TABLE moedas(
	id INT IDENTITY PRIMARY KEY,
	nome VARCHAR(30),
	cotacao MONEY
)

CREATE TABLE ordens(
	id INT IDENTITY PRIMARY KEY,
	id_cliente INT,
	id_moeda INT,
	id_conta_simply INT,
	tipo VARCHAR(1),
	quantidade_moedas INT,
	data_ordem DATE,
	valor_ordem MONEY,
	status_ordem VARCHAR(1),
	FOREIGN KEY (id_cliente) REFERENCES cliente(id),
	FOREIGN KEY (id_moeda) REFERENCES moedas(id),
	FOREIGN KEY (id_conta_simply) REFERENCES conta_cliente_simply(id)
)

SELECT * FROM conta_cliente_simply;
SELECT * FROM ordens;
UPDATE ordens
SET status_ordem = 'A'
