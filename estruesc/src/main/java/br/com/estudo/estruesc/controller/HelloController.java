package br.com.estudo.estruesc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/hello-modelandview")
    public ModelAndView Hello(){
        ModelAndView mv = new ModelAndView("hello"); // O nome do arquivo HTML a ser renderizado
        mv.addObject("nome", "Moreira");
        return mv; // Spring vai renderizar o arquivo templates/hello.html
    }

    @GetMapping("/hello")
    public String Hello(Model model){
        model.addAttribute("nome", "Matheus");
        return "hello"; // Spring vai renderizar o arquivo templates/hello.html
    }
}
