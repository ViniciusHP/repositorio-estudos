CREATE OR REPLACE FUNCTION salario_ok(instrutor instrutor) RETURNS VARCHAR AS $$
	BEGIN
    /* CASE
      WHEN instrutor.salario = 100 THEN
        RETURN 'Salário muito baixo';
      WHEN instrutor.salario = 200 THEN
        RETURN 'Salário baixo';
      WHEN instrutor.salario = 300 THEN
        RETURN 'Salário ok';
      ELSE
        RETURN 'Salário ótimo';
    END CASE; */
    CASE instrutor.salario
      WHEN 100 THEN
        RETURN 'Salário muito baixo';
      WHEN 200 THEN
        RETURN 'Salário baixo';
      WHEN 300 THEN
        RETURN 'Salário ok';
      ELSE
        RETURN 'Salário ótimo';
    END CASE;
	END;
$$ LANGUAGE PLPGSQL;

SELECT nome, salario_ok(instrutor.*) FROM instrutor;
