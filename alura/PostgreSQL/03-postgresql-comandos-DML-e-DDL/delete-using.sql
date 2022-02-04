DELETE FROM curso
      USING categoria
      WHERE categoria.id = curso.categoria_id
        AND categoria.nome = 'Teste';