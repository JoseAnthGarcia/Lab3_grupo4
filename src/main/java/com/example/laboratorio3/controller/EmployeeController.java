package com.example.laboratorio3.controller;
import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.repository.DepartmentRepository;
import com.example.laboratorio3.repository.EmployeesRepository;
import com.example.laboratorio3.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String listaEmployee(Model model){
        model.addAttribute("listaEmployees", employeesRepository.findAll());
        return "/employee/lista";
    }


    @GetMapping("/new")
    public String nuevoEmployeeForm(Model model) {
        model.addAttribute("listaTrabajos", jobRepository.findAll());
        model.addAttribute("listajefes", employeesRepository.findAll());
        model.addAttribute("listaDepartamentos", departmentRepository.findAll());
        return "/employee/newFrm";
    }

    @PostMapping("/save")
    public String guardarEmployee(Employees employees, RedirectAttributes attr) {
        if (employees.getEmployee_id()== 0) {
            attr.addFlashAttribute("msg", "Producto creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Producto actualizado exitosamente");
        }
        employeesRepository.save(employees);
        return "redirect:/employee";

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

    @GetMapping("/delete")
    public String borrarEmpleado(Model model,
                                 @RequestParam("id") int id,
                                 RedirectAttributes attr) {

        Optional<Employees> optionalEmployees = employeesRepository.findById(id);

        if (optionalEmployees.isPresent()) {
            employeesRepository.deleteById(id);
            attr.addFlashAttribute("msg","Producto borrado exitosamente");
        }
        return "redirect:/employee";

    }

    //COMPLETAR

}
