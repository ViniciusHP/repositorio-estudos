CREATE OR REPLACE FUNCTION salario_ok(instrutor instrutor) RETURNS VARCHAR AS $$
	BEGIN
		IF instrutor.salario > 300 THEN
			RETURN 'Salário está ok';
		ELSEIF instrutor.salario = 300 THEN
				RETURN 'Salário pode aumentar';
		ELSE
			RETURN 'Salário está defasado';
		END IF;
	END;
$$ LANGUAGE PLPGSQL;

SELECT nome, salario_ok(instrutor.*) FROM instrutor;
