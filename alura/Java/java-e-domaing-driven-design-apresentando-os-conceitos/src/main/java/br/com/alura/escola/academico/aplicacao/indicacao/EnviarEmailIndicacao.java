package br.com.alura.escola.academico.academico.aplicacao.indicacao;

import br.com.alura.escola.academico.academico.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
	
	void enviarPara(Aluno indicado);

}
