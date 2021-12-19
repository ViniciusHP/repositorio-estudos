SELECT (primeiro_nome || ' ' || ultimo_nome) AS nome_completo FROM aluno

SELECT TRIM(UPPER(CONCAT('Vinicius', ' ', null, 'Pereira')) || ' ');

SELECT CONCAT(primeiro_nome, ' ', ultimo_nome) AS nome_completo,
	   (now()::DATE - data_nascimento) / 365 AS idade
FROM aluno;

SELECT CONCAT(primeiro_nome, ' ', ultimo_nome) AS nome_completo,
	   AGE(data_nascimento) AS idade
FROM aluno;

SELECT CONCAT(primeiro_nome, ' ', ultimo_nome) AS nome_completo,
	   EXTRACT(YEAR FROM AGE(data_nascimento)) AS idade
FROM aluno;

SELECT @ -172569845;

SELECT now()::date; 