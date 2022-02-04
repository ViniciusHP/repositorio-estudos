CREATE OR REPLACE FUNCTION cria_instrutor_false() RETURNS instrutor AS $$
	SELECT 22, 'Nome falso', 200::DECIMAL;
$$ LANGUAGE SQL;

SELECT * FROM cria_instrutor_false();