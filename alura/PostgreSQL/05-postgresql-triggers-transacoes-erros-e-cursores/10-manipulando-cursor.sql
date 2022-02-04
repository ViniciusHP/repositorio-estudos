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
		logs_inseridos INTEGER;
    	cursor_salarios REFCURSOR;
	BEGIN
		id_instrutor_inserido := NEW.id;
		salario_instrutor := NEW.salario;
		nome_instrutor := NEW.nome;

		SELECT AVG(instrutor.salario) INTO media_salarial FROM instrutor WHERE id <> id_instrutor_inserido;
		
		IF salario_instrutor > media_salarial THEN
			INSERT INTO log_instrutores (informacao) VALUES (nome_instrutor || ' recebe acima da média.');
      GET DIAGNOSTICS logs_inseridos = ROW_COUNT;

      IF logs_inseridos > 1 THEN
        RAISE EXCEPTION 'Algo de errado não está certo';
      END IF;
		END IF;
		
    SELECT instrutores_internos(NEW.id) INTO cursor_salarios;
		LOOP
      FETCH cursor_salarios INTO salario;
      EXIT WHEN NOT FOUND; -- Se não houver mais nada no cursor
			total_instrutores := total_instrutores + 1;
			
			IF salario < salario_instrutor THEN
				instrutores_recebem_menos := instrutores_recebem_menos + 1;
			END IF;
		END LOOP;
		
		percentual := instrutores_recebem_menos::DECIMAL / total_instrutores::DECIMAL * 100;
		ASSERT percentual < 100::DECIMAL, 'Instrutores novos não podem receber mais que instrutores antigos.'; 

		INSERT INTO log_instrutores (informacao, teste) -- Adicionando coluna 'teste' que é inexistente para ocorrer erro
			VALUES (nome_instrutor || ' recebe mais do que ' || percentual || '% da grade de instrutores', '');

    	RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;

INSERT INTO instrutor (nome, salario) VALUES ('Clóvis', 2000);