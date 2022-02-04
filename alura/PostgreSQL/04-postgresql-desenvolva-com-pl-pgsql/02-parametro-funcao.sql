CREATE FUNCTION soma_dois_numeros(numero_1 INTEGER, numero_2 INTEGER) RETURNS INTEGER AS '
  SELECT numero_1 + numero_2;
' LANGUAGE SQL;

SELECT soma_dois_numeros(2, 2);

DROP FUNCTION soma_dois_numeros;

CREATE FUNCTION soma_dois_numeros(INTEGER, INTEGER) RETURNS INTEGER AS '
  SELECT $1 + $2;
' LANGUAGE SQL;

SELECT soma_dois_numeros(3, 17);