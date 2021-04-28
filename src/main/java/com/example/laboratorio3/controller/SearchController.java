package com.example.laboratorio3.controller;

import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = {"","/"})
    public String indice(){
        return "/Search/indice";
    }

    @GetMapping("/salarioMayor15000")
    public String salarioMayor15000(Model model){
        model.addAttribute("listaEmployee15000", employeesRepository.obtenerEmpleadoSalario());
        return "/Search/salarioMayor15000";
    }

    @GetMapping("/gerentesConExperiencia")
    public String gerentesConExperiencia(Model model){
        model.addAttribute("listaGerentesExperiencia", employeesRepository.obtenerGerentes());
        return "/Search/gerentesConExperiencia";
    }


//COMPLETAR


}
