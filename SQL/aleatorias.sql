INSERT INTO endereco(
	logradouro,
	bairro,
	UF,
	numero,
	complemento
)VALUES(
	'Rua Brasil',
	'Butantã',
	'SP',
	55,
	'Final da rua, prédio 2'
)

INSERT INTO cliente(
	cnpj_cpf,
	id_endereco,
	nome,
	data_nascimento
)VALUES (
	'65917526095',
	1,
	'Alex Jesus',
	'15/09/2001'
)

INSERT INTO conta_cliente(
	cod_banco,
	id_cliente,
	cod_agencia,
	cod_conta,
	principal
)VALUES(
	1,
	1,
	0001,
	541236857,
	1
)

INSERT INTO conta_cliente_simply(
	cod_banco,
	id_cliente,
	cod_agencia,
	cod_conta,
	saldo,
	data_saldo
)VALUES(
	999,
	1,
	0001,
	123456789,
	147852.99,
	GETDATE()
)

INSERT INTO moedas(
	nome,
	cotacao
)VALUES(
	'BTC',
	1274.80
)