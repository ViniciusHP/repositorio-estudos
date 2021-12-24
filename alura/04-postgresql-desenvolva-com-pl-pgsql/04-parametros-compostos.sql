CREATE TABLE instrutor(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	salario DECIMAL(10,2)
);

INSERT INTO instrutor (nome, salario) VALUES ('Vinicius Dias', 100);

SELECT * FROM instrutor;

CREATE FUNCTION dobro_do_salario(instrutor) RETURNS DECIMAL AS $$
	SELECT $1.salario * 2 AS dobro;
$$ LANGUAGE SQL;

SELECT nome, dobro_do_salario(instrutor.*) FROM instrutor;