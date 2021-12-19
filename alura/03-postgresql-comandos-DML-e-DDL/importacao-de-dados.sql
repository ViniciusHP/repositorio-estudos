CREATE SCHEMA teste;

CREATE TABLE teste.curso_programacao(
	id_curso INTEGER PRIMARY KEY,
	nome_curso VARCHAR(255) NOT NULL
);

INSERT INTO teste.curso_programacao
SELECT academico.curso.id,
	   academico.curso.nome
FROM academico.curso
JOIN academico.categoria ON academico.categoria.id = academico.curso.categoria_id
WHERE curso.categoria_id = 2;

SELECT * FROM teste.curso_programacao;

-- Importação
copy teste.curso_programacao (id_curso, nome_curso) FROM 'C:/Users/VINICI~1/DOCUME~1/cursos' DELIMITER ',' CSV HEADER ENCODING 'UTF8' QUOTE '\"' ESCAPE '''';""

-- Exportação
copy teste.curso_programacao (id_curso, nome_curso) TO 'C:/Users/VINICI~1/DOCUME~1/cursos' DELIMITER ',' CSV HEADER ENCODING 'UTF8' QUOTE '\"' ESCAPE '''';""