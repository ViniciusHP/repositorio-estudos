UPDATE teste.cursos_programacao SET nome_curso = nome
FROM academico.curso WHERE teste.cursos_programacao.id_curso = academico.curso.id
AND academico.curso.id < 10;