package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Arrays;

@Controller
public class HomeController {

    @GetMapping("home")
    public String home(Model model) {
        Pedido pedido = Pedido
                .builder()
                .nomeProduto("Xiaome Redmi Note 8")
                .urlImagem("https://m.media-amazon.com/images/I/51RIqTiRc8L._AC_SX569_.jpg")
                .urlProduto("https://www.amazon.com.br/Smartphone-Xiaomi-Redmi-Note-Camera/dp/B07Z5BBG56")
                .valorNegociado(new BigDecimal("1299.89"))
                .descricao("Descrição qualquer para esse pedido")
                .build();

        model.addAttribute("pedidos", Arrays.asList(pedido));

        return "home";
    }
}
