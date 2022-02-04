DROP ROLE vinicius;
CREATE ROLE vinicius LOGIN PASSWORD '123456';
REVOKE ALL ON DATABASE alura FROM vinicius;

SELECT COUNT(*) FROM instrutor

GRANT SELECT ON public.instrutor TO vinicius;