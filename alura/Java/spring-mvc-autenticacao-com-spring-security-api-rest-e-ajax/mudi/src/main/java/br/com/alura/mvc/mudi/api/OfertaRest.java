package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertaRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public ResponseEntity<Oferta> criaOferta(@Valid @RequestBody RequisicaoNovaOferta novaOferta) {
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(novaOferta.getPedidoId());

        if(pedidoBuscado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Pedido pedido = pedidoBuscado.get();
        Oferta oferta = novaOferta.toOferta();
        oferta.setPedido(pedido);
        pedido.getOfertas().add(oferta);
        pedidoRepository.save(pedido);

        return ResponseEntity.ok(oferta);
    }
}
