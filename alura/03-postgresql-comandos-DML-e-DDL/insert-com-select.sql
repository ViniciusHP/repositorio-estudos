CREATE TEMPORARY TABLE curso_programacao(
	id_curso INTEGER PRIMARY KEY,
	nome_curso VARCHAR(255) NOT NULL
);

INSERT INTO curso_programacao
SELECT academico.curso.id,
	   academico.curso.nome
FROM academico.curso
JOIN academico.categoria ON academico.categoria.id = academico.curso.categoria_id
WHERE curso.categoria_id = 2;

SELECT * FROM curso_programacao;