INSERT INTO aluno (primeiro_nome, ultimo_nome, data_nascimento)
VALUES ('Vinicius', 'Pereira', '1997-05-15'),
	   ('Angela', 'Soares', '1989-02-20'),
	   ('Gabrieli', 'Vasconcelos', '1998-10-17'),
	   ('Matheus', 'Ferreira', '1994-08-23');
	  
INSERT INTO categoria (nome)
VALUES ('PROGRAMAÇÃO'),
	   ('FRONT-END'),
	   ('DATA SCIENCE'),
	   ('DEVOPS'),
	   ('UX & DESIGN'),
	   ('MOBILE'),
	   ('INOVAÇÃO & GESTÃO');
	  
INSERT INTO curso (nome, categoria_id)
VALUES ('Kotlin', 1),
	   ('JavaScript para back-end', 1),
	   ('ReactJS', 2),
	   ('Angular', 2),
	   ('Machine Learning', 3),
	   ('Modalagem de Dados', 3),
	   ('Apache Kafka', 4),
	   ('Amazon Web Services', 4),
	   ('Figma', 5),
	   ('Adobe XD', 5),
	   ('Android', 6),
	   ('Flutter', 6),
	   ('Comunicação', 7),
	   ('Produtividade', 7);
	  
INSERT INTO aluno_curso (aluno_id, curso_id)
VALUES (1, 1),
	   (1, 2),
	   (1, 4),
	   (1, 11),
	   (2, 2),
	   (2, 3),
	   (2, 5),
	   (2, 7),
	   (3, 9),
	   (3, 10),
	   (3, 12),
	   (3, 13),
	   (3, 14),
	   (4, 8),
	   (4, 6),
	   (4, 3),
	   (4, 12);
	  
