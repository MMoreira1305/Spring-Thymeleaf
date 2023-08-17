package br.com.estudo.estruesc.controller;

import br.com.estudo.estruesc.models.Professor;
import br.com.estudo.estruesc.repositorio.ProfessorRepository;
import br.com.estudo.estruesc.servico.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    private ProfessorService servicoProfessor;

    @GetMapping("/professores")
    public ModelAndView index() {

        List<Professor> professores = this.professorRepository.findAll();

        ModelAndView mv = new ModelAndView("./professores/index.html");
        mv.addObject("professores", professores);

        return mv;
    }

    @GetMapping("professores/cadastro")
    public ModelAndView form(){
        ModelAndView mv = new ModelAndView("./professores/cadastro.html");
        return mv;
    }

    @PostMapping("professores/cadastro")
    public ModelAndView cadastro(Professor professor){
        servicoProfessor.cadastrarProfessor(professor);
        ModelAndView mv = new ModelAndView("redirect:/professores");
        mv.getStatus();
        return mv;
    }

    @GetMapping("professores/{id}")
    public ModelAndView detalhes(@PathVariable Long id){
        Professor professor = professorRepository.findById(id);
        ModelAndView mv = new ModelAndView("./professores/detalhes.html");
        mv.addObject("professor", professor);
        return mv;
    }

    @GetMapping("professores/{id}/edit")
    public ModelAndView alterarView(@PathVariable Long id){
        Professor professor = professorRepository.findById(id);
        ModelAndView mv = new ModelAndView("./professores/alter.html");
        mv.addObject("professor", professor);
        return mv;
    }

    @PostMapping("professores/{id}/edit")
    public ModelAndView alterar(@PathVariable Long id, Professor professor){
        professorRepository.save(professor);
        ModelAndView mv = new ModelAndView("redirect:/professores");
        mv.addObject("id", id);
        return mv;
    }

    @GetMapping("professores/delete")
    public String deletar(@RequestParam Integer professorId){
        servicoProfessor.deletarProfessor(professorId);
        System.out.println("Ok");
        return "redirect:/professores";
    }
}
