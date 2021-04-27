package com.example.laboratorio3.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    //COMPLETAR

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


    public String editarEmployee() {
        //COMPLETAR
    }


    public String borrarEmpleado() {

       //COMPLETAR

    }

    //COMPLETAR

}
