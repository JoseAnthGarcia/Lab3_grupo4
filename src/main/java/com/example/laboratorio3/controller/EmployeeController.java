package com.example.laboratorio3.controller;
import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.DepartmentRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import com.example.laboratorio3.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    //COMPLETAR
    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    JobRepository jobRepository;
    @Autowired
    DepartmentRepository departmentRepository;


    @GetMapping("/listar")
    public String listaEmployee(){
        return "/employee/lista";
    }

    public String nuevoEmployeeForm( ) {
        //COMPLETAR
    }


    public String guardarEmployee() {
        //COMPLETAR
    }


    @GetMapping("/edit")
    public String editarEmployee(Model model, @RequestParam("id") int id) {
        Optional<Employees> optionalEmployees = employeesRepository.findById(id);

        if (optionalEmployees.isPresent()) {
            Employees employee = optionalEmployees.get();
            model.addAttribute("employee", employee);
            model.addAttribute("listaTrabajos", jobRepository.findAll());
            model.addAttribute("listajefes", employeesRepository.findAll());
            model.addAttribute("listaDepartamentos", departmentRepository.findAll());
            return "employee/editFrm";
        } else {
            return "redirect:/employee/list";
        }
    }


    public String borrarEmpleado() {

       //COMPLETAR

    }

    //COMPLETAR

}
