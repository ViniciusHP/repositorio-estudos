package br.com.alura.alurator.conversor;

import br.com.alura.alurator.conversor.anotacao.NomeTagXML;

import java.lang.reflect.Field;
import java.util.Collection;

public class ConversorXML {
    public String converte(Object objeto) {
        try {
            Class<?> classeObjeto = objeto.getClass();
            StringBuffer xmlBuilder = new StringBuffer();

            if(objeto instanceof Collection<?> colecao) {
                xmlBuilder.append("<lista>");

                for(Object o : colecao) {
                    String xml = converte(o);
                    xmlBuilder.append(xml);
                }

                xmlBuilder.append("</lista>");
            } else {
                NomeTagXML anotacaoClasse = classeObjeto.getDeclaredAnnotation(NomeTagXML.class);

                String nomeClasse = anotacaoClasse == null
                        ? classeObjeto.getName()
                        : anotacaoClasse.value();

                xmlBuilder.append("<"+nomeClasse+">");
                for(Field atributo: classeObjeto.getDeclaredFields()) {
                    atributo.setAccessible(true);
                    NomeTagXML anotacaoAtributo = atributo.getDeclaredAnnotation(NomeTagXML.class);

                    String nomeAtributo = anotacaoAtributo == null
                            ? atributo.getName()
                            : anotacaoAtributo.value();

                    Object valorAtributo = atributo.get(objeto);
                    xmlBuilder.append("<"+nomeAtributo+">");
                    xmlBuilder.append(valorAtributo);
                    xmlBuilder.append("</"+nomeAtributo+">");
                }
                xmlBuilder.append("</"+nomeClasse+">");
            }

        return xmlBuilder.toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro na geração do XML!", e);
        }
    }
}
