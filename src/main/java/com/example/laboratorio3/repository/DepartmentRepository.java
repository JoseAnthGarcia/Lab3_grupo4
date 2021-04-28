package com.example.laboratorio3.repository;

import com.example.laboratorio3.dto.DepartamentoPaisCiudad;
import com.example.laboratorio3.dto.EmpleadosSalarioMayor;
import com.example.laboratorio3.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query(value = "select c.country_name as `pais`, l.city as `ciudad`, count(d.department_id) as `cantidad`from departments d\n" +
            "left join locations l on d.location_id = l.location_id\n" +
            "left join countries c on l.country_id = c.country_id\n" +
            "where d.department_id in (select department_id from employees group by department_id\n" +
            "having count(employee_id)>3) group by l.city", nativeQuery = true)
    List<DepartamentoPaisCiudad> obtenerCantidadDepartamentos();
}
