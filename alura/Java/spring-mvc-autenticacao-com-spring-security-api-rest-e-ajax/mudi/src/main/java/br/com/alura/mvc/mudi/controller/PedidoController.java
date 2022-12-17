package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("formulario")
    public ModelAndView formulario(RequisicaoNovoPedido requisicao, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("pedido/formulario");
        modelAndView.addObject("requisicao", requisicao);
        return modelAndView;
    }

    @PostMapping("novo")
    public ModelAndView novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("pedido/formulario");
        modelAndView.addObject("requisicao", requisicao);

        if(result.hasErrors()) {
            return modelAndView;
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Pedido pedido = requisicao.toPedido();
        userRepository.findByUsername(username)
                .ifPresent(pedido::setUser);
        pedidoRepository.save(pedido);

        modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }
}
