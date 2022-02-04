CREATE FUNCTION primeira_funcao() RETURNS INTEGER AS '
  SELECT (5 - 3) * 2
' LANGUAGE SQL;

SELECT primeira_funcao();
SELECT primeira_funcao() AS numero;
SELECT * FROM primeira_funcao();