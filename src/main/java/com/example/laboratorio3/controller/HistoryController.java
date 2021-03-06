package com.example.laboratorio3.controller;


import com.example.laboratorio3.repository.DepartmentRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import com.example.laboratorio3.repository.HistoryRepository;
import com.example.laboratorio3.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    JobRepository jobRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    HistoryRepository historyRepository;

    @GetMapping("/listar")
    public String listaEmployee(Model model){
        model.addAttribute("listaHistory", historyRepository.findAll());
        return "/history/history";
    }

    @PostMapping("/textSearch")
    public String buscardor(@RequestParam("textBuscador") String textBuscador, Model model){
        model.addAttribute("listaHistory", historyRepository.buscarInputBuscador(textBuscador));
        model.addAttribute("texto", textBuscador);
        return "/history/history";
    }

}
