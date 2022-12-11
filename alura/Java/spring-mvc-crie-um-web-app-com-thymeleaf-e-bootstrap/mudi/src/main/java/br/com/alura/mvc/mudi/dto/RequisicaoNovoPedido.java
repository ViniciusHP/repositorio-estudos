package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequisicaoNovoPedido {
    private String nomeProduto;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    public Pedido toPedido() {
        return Pedido.builder()
                .nomeProduto(nomeProduto)
                .urlProduto(urlProduto)
                .urlImagem(urlImagem)
                .descricao(descricao)
                .build();
    }
}
