package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping()
    public String home(Model model) {

        Sort sort = Sort.by("dataDeEntrega").descending();
        PageRequest paginacao = PageRequest.of(0, 1, sort);

        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
        model.addAttribute("pedidos", pedidos);

        return "home";
    }

//    @GetMapping("home")
//    public ModelAndView home() {
//
//        List<Pedido> pedidos = pedidoRepository.findAll();
//        ModelAndView mv = new ModelAndView("home");
//        mv.addObject("pedidos", pedidos);
//        return mv;
//    }
}
