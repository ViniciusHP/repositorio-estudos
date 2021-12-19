
SELECT curso.nome FROM curso WHERE categoria_id IN (
	SELECT id FROM categoria WHERE nome NOT LIKE '% %'
);

SELECT *
FROM (
	SELECT categoria.nome AS categoria,
			count(curso.id) AS numero_cursos
	FROM categoria
	JOIN curso ON curso.categoria_id = categoria.id
	GROUP BY categoria
) AS categoria_cursos
WHERE numero_cursos >= 2


  SELECT curso.nome,
         COUNT(aluno_curso.aluno_id) numero_alunos
    FROM curso
    JOIN aluno_curso ON aluno_curso.curso_id = curso.id
GROUP BY 1
  HAVING COUNT(aluno_curso.aluno_id) > 2
ORDER BY numero_alunos DESC;


-- Minha Versão
SELECT nome_curso AS nome,
	   numero_alunos
 FROM (
 	SELECT curso.nome AS nome_curso,
 		   count(aluno_curso.aluno_id) AS numero_alunos
	  FROM curso
	  JOIN aluno_curso ON aluno_curso.curso_id = curso.id
	  GROUP BY curso.nome
 ) AS cursos_aluno
 WHERE numero_alunos > 2
 ORDER BY numero_alunos DESC;
 
-- Versão do professor

  SELECT t.curso,
         t.numero_alunos
    FROM (
        SELECT curso.nome AS curso,
               COUNT(aluno_curso.aluno_id) numero_alunos
          FROM curso
          JOIN aluno_curso ON aluno_curso.curso_id = curso.id
      GROUP BY 1
    ) AS t
    WHERE t.numero_alunos > 2
  ORDER BY t.numero_alunos DESC;