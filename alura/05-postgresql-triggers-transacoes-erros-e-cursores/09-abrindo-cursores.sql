CREATE OR REPLACE FUNCTION instrutores_internos(id_instrutores INTEGER) RETURNS REFCURSOR AS $$
  DECLARE
    cursor_salarios REFCURSOR;
    -- salario DECIMAL;
  BEGIN
    OPEN cursor_salarios FOR SELECT instrutor.salario FROM instrutor WHERE id <> id_instrutores AND salario > 0;

    -- Manipulando Cursor
    -- FETCH
    -- FETCH LAST FROM cursor_salarios INTO salario;
    -- FETCH NEXT FROM cursor_salarios INTO salario;
    -- FETCH PRIOR FROM cursor_salarios INTO salario;
    -- FETCH FIRST FROM cursor_salarios INTO salario;
    
    -- MOVE
    -- MOVE LAST FROM cursor_salarios;
    -- MOVE NEXT FROM cursor_salarios;
    -- MOVE PRIOR FROM cursor_salarios;
    -- MOVE FIRST FROM cursor_salarios;

    -- CLOSE
    -- CLOSE cursor_salarios;

    return cursor_salarios;
  END;
$$ LANGUAGE PLPGSQL;