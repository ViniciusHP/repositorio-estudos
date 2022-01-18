CREATE OR REPLACE FUNCTION instrutores_internos(id_instrutores INTEGER) RETURNS ??? AS $$
  DECLARE
    cursor_salarios REFCURSOR;
  BEGIN
    OPEN cursor_salarios FOR SELECT instrutor.salario FROM instrutor WHERE id <> id_instrutores AND salario > 0;
  END;
$$ LANGUAGE PLPGSQL;