package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.utils.LocalDateUtils;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RequisicaoNovaOferta {

    @NotNull
    private Long pedidoId;

    @NotNull
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$")
    private String valor;

    @NotNull
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
    private String dataDeEntrega;
    private String comentario;

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario(this.comentario);
        oferta.setDataDaEntrega(LocalDateUtils.toLocalDate(this.dataDeEntrega));
        oferta.setValor(new BigDecimal(this.valor));
        return oferta;
    }
}
