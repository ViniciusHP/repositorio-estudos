--START TRANSACTION;
BEGIN;
DELETE FROM teste.curso_programacao;
SELECT * FROM teste.curso_programacao;
ROLLBACK;

BEGIN;
DELETE FROM teste.curso_programacao WHERE id_curso = 60;
COMMIT;