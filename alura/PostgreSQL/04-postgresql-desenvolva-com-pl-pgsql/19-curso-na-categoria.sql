CREATE DATABASE alura;

CREATE TABLE aluno (
  id SERIAL PRIMARY KEY,
  primeiro_nome VARCHAR(255) NOT NULL,
  ultimo_nome VARCHAR(255) NOT NULL,
  data_nascimento DATE NOT NULL
);

CREATE TABLE categoria (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE curso (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  categoria_id INTEGER NOT NULL REFERENCES categoria(id)
);

CREATE TABLE aluno_cruso (
  aluno_id INTEGER NOT NULL REFERENCES aluno(id),
  curso_id INTEGER NOT NULL REFERENCES curso(id),
  PRIMARY KEY (aluno_id, curso_id)
);

CREATE OR REPLACE FUNCTION cria_curso(nome_curso VARCHAR, nome_categoria VARCHAR) RETURNS curso AS $$
	DECLARE
		id_categoria INTEGER;
		curso curso;
	BEGIN
		SELECT id FROM categoria WHERE nome = nome_categoria INTO id_categoria;
		
		IF NOT FOUND THEN
		--IF id_categoria IS NULL THEN
			 INSERT INTO categoria (nome) VALUES (nome_categoria) RETURNING id INTO id_categoria;
		END IF;
		
		INSERT INTO curso (nome, categoria_id) VALUES (nome_curso, id_categoria) RETURNING * INTO curso;
		RETURN curso;
	END;
$$ LANGUAGE PLPGSQL;

SELECT * FROM cria_curso('Java', 'Programação');
SELECT * FROM cria_curso('C#', 'Programação');
SELECT * FROM cria_curso('Figma', 'UI/UX');
SELECT * FROM cria_curso('Adobe XD', 'UI/UX');
SELECT * FROM cria_curso('Processamento de dados', 'Ciência de Dados');

SELECT * FROM categoria;
SELECT * FROM curso;
