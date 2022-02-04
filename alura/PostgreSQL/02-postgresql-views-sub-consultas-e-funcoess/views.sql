CREATE VIEW vw_cursos_por_categoria AS
SELECT categoria.nome AS categoria,
		count(curso.id) AS numero_cursos
FROM categoria
JOIN curso ON curso.categoria_id = categoria.id
GROUP BY categoria

SELECT * FROM vw_cursos_por_categoria;

SELECT categoria
FROM vw_cursos_por_categoria AS categoria_cursos
WHERE numero_cursos >= 3;

CREATE VIEW vw_cursos_programacao AS
SELECT nome 
FROM curso
WHERE categoria_id = 2;

SELECT * FROM vw_cursos_programacao;

SELECT vw_cursos_por_categoria.*,
		categoria.id AS categoria_id
FROM vw_cursos_por_categoria
JOIN categoria ON categoria.nome = vw_cursos_por_categoria.categoria