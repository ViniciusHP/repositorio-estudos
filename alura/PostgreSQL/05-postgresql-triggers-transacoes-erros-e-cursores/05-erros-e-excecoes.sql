DROP FUNCTION cria_instrutor;

CREATE OR REPLACE FUNCTION cria_instrutor() RETURNS TRIGGER AS $$
	DECLARE
		salario_instrutor DECIMAL;
		nome_instrutor VARCHAR;
		id_instrutor_inserido INTEGER;
		
		media_salarial DECIMAL;
		instrutores_recebem_menos INTEGER DEFAULT 0;
		total_instrutores INTEGER DEFAULT 0;
		salario DECIMAL;
		percentual DECIMAL(5, 2);
	BEGIN
		id_instrutor_inserido := NEW.id;
		salario_instrutor := NEW.salario;
		nome_instrutor := NEW.nome;

		SELECT AVG(instrutor.salario) INTO media_salarial FROM instrutor WHERE id <> id_instrutor_inserido;
		
		IF salario_instrutor > media_salarial THEN
			INSERT INTO log_instrutores (informacao) VALUES (nome_instrutor || ' recebe acima da média.');
		END IF;
		
		FOR salario IN SELECT instrutor.salario FROM instrutor WHERE id <> id_instrutor_inserido LOOP
			total_instrutores := total_instrutores + 1;
			
			IF salario < salario_instrutor THEN
				instrutores_recebem_menos := instrutores_recebem_menos + 1;
			END IF;
		END LOOP;
		
		percentual := instrutores_recebem_menos::DECIMAL / total_instrutores::DECIMAL * 100;
		
		INSERT INTO log_instrutores (informacao, teste) -- Adicionando coluna 'teste' que é inexistente para ocorrer erro
			VALUES (nome_instrutor || ' recebe mais do que ' || percentual || '% da grade de instrutores', '');

    	RETURN NEW;
	
	EXCEPTION
		WHEN undefined_column THEN
			RAISE NOTICE 'Exceção ''undefined_column'' foi lançada';
			RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;

DROP TRIGGER verifica_instrutores ON instrutor;
DROP TRIGGER rejeita_instrutores_com_maior_media_salarial ON instrutor;

CREATE TRIGGER cria_log_instrutores AFTER INSERT ON instrutor
  FOR EACH ROW EXECUTE FUNCTION cria_instrutor();
  
SELECT * FROM instrutor;
SELECT * FROM log_instrutores;

INSERT INTO instrutor (nome, salario) VALUES ('Mairo', 1000);
