package com.example.laboratorio3.dto;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartamentoPaisCiudad {
    String getPis();
    String getCiudad();
    String getDepartamentos();
}
