package com.example.laboratorio3.dto;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartamentoPaisCiudad {
    String getPais();
    String getCiudad();
    String getDepartamentos();
}
