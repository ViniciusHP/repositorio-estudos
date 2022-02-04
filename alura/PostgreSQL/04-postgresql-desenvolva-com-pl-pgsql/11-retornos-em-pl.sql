CREATE OR REPLACE FUNCTION primeira_funcao() RETURNS INTEGER AS $$
	BEGIN
		RETURN (5 - 3) * 2;
	END
$$ LANGUAGE PLPGSQL;

SELECT primeira_funcao();

CREATE OR REPLACE FUNCTION soma_dois_numeros(INTEGER, INTEGER) RETURNS INTEGER AS $$
	BEGIN
		RETURN $1 + $2;
	END
$$ LANGUAGE PLPGSQL;

SELECT soma_dois_numeros(3, 17);

CREATE OR REPLACE FUNCTION cria_a(nome VARCHAR) RETURNS VOID AS $$
	BEGIN
  		INSERT INTO a (nome) VALUES (cria_a.nome);
	END
$$ LANGUAGE PLPGSQL;

SELECT cria_a('Vinicius');

-- Retorno Composto

CREATE OR REPLACE FUNCTION cria_instrutor_false() RETURNS instrutor AS $$
	DECLARE
		retorno instrutor;
	BEGIN
		SELECT 22, 'Nome falso', 200::DECIMAL INTO retorno;
		RETURN retorno;
	END;
$$ LANGUAGE PLPGSQL;

CREATE OR REPLACE FUNCTION cria_instrutor_false() RETURNS instrutor AS $$
	BEGIN
		RETURN ROW(22, 'Nome falso', 200::DECIMAL)::instrutor;
	END;
$$ LANGUAGE PLPGSQL;

SELECT * FROM cria_instrutor_false();

-- Conjunto

DROP FUNCTION instrutores_bem_pagos;
CREATE FUNCTION instrutores_bem_pagos(valor_salario DECIMAL) RETURNS SETOF instrutor AS $$
	BEGIN
		RETURN QUERY SELECT * FROM instrutor WHERE salario > valor_salario;
	END;
$$ LANGUAGE PLPGSQL;

SELECT * FROM instrutores_bem_pagos(300);