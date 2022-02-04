CREATE FUNCTION salario_ok(instrutor instrutor) RETURNS VARCHAR AS $$
	BEGIN
		IF instrutor.salario > 200 THEN
			RETURN 'Salário está ok';
		ELSE
			RETURN 'Salário pode aumentar';
		END IF;
	END;
$$ LANGUAGE PLPGSQL;

SELECT nome, salario_ok(instrutor.*) FROM instrutor;

-- Menos performático
DROP FUNCTION salario_ok;
CREATE FUNCTION salario_ok(id_instrutor INTEGER) RETURNS VARCHAR AS $$
	DECLARE
		instrutor instrutor;
	BEGIN
		SELECT * FROM instrutor WHERE id = id_instrutor INTO instrutor;
	
		IF instrutor.salario > 200 THEN
			RETURN 'Salário está ok';
		ELSE
			RETURN 'Salário pode aumentar';
		END IF;
	END;
$$ LANGUAGE PLPGSQL;

SELECT nome, salario_ok(instrutor.id) FROM instrutor;
