CREATE SCHEMA academico;

CREATE TABLE IF NOT EXISTS academico.aluno (
	id SERIAL PRIMARY KEY,
	primeiro_nome VARCHAR(255) NOT NULL,
	ultimo_nome VARCHAR(255) NOT NULL,
	data_nascimento DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS academico.categoria (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS academico.curso (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	categoria_id INTEGER NOT NULL REFERENCES academico.categoria (id)
);

CREATE TABLE IF NOT EXISTS academico.aluno_curso (
	aluno_id INTEGER NOT NULL REFERENCES academico.aluno(id),
	curso_id INTEGER NOT NULL REFERENCES academico.curso(id),
	PRIMARY KEY (aluno_id, curso_id)
);