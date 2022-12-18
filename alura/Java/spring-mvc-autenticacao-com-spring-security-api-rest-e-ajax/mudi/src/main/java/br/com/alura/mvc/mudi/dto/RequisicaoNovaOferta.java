package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.utils.LocalDateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RequisicaoNovaOferta {
    private Long pedidoId;
    private String valor;
    private String dataDaEntrega;
    private String comentario;

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario(this.comentario);
        oferta.setDataDaEntrega(LocalDateUtils.toLocalDate(this.dataDaEntrega));
        oferta.setValor(new BigDecimal(this.valor));
        return oferta;
    }
}
