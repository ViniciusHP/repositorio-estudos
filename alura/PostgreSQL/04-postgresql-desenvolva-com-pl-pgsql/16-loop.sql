DROP FUNCTION tabuada;
CREATE OR REPLACE FUNCTION tabuada(numero INTEGER) RETURNS SETOF VARCHAR AS $$
	DECLARE
		multiplicador INTEGER DEFAULT 1;
	BEGIN
		LOOP
			-- 9 x 1 = 9
			--RETURN NEXT CONCAT(numero, ' x ', multiplicador, ' = ', numero * multiplicador);
			RETURN NEXT numero || ' x ' || multiplicador || ' = ' || numero * multiplicador;
			multiplicador := multiplicador + 1;
			EXIT WHEN multiplicador = 10;
		END LOOP;
	END;
$$ LANGUAGE PLPGSQL;

SELECT tabuada(9);