DROP TABLE instrutor CASCADE;
CREATE TABLE instrutor (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  salario DECIMAL(10, 2)
);

SELECT COUNT(*) FROM instrutor;

DO $$
  DECLARE
  BEGIN
    FOR i IN 1..1000000 LOOP
      INSERT INTO instrutor (nome, salario) VALUES ('Instrutor(a) ' || i, random() * 1000 + 1);
    END LOOP;
  END;
$$ LANGUAGE PLPGSQL;

UPDATE instrutor SET salario = salario * 2 WHERE id % 2 = 1;
DELETE FROM instrutor WHERE id % 2 = 0;

SELECT relname, n_dead_tup FROM pg_stat_user_tables; -- Número de tuplas mortas
SELECT pg_size_pretty(pg_relation_size('instrutor')) -- Mostra o 'tamanho' que a tabela está ocupando

VACUUM;
VACUUM VERBOSE; -- Explica como foi feito o vacuum
VACUUM FULL; -- Realiza a tarefa de limpeza e compactação, mas bloqueia os clientes da tabela
VACUUM ANALYSE instrutor; -- Remonta as estatísticas do postgres para filtrar dados, ordernação dados etc...