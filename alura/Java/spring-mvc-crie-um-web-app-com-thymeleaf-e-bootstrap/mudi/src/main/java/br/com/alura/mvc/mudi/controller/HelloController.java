package br.com.alura.mvc.mudi.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("nome", "Vinicius");
        return "hello";
    }
}
