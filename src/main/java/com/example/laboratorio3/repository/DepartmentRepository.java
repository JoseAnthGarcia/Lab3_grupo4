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
    @Query(value = "SELECT c.country_name as pais, l.city as ciudad ,  count(e.department_id) AS `Departamentos`\n" +
            "FROM countries c\n" +
            "INNER JOIN locations l ON (l.country_id = c.country_id)\n" +
            "INNER JOIN departments d ON (d.location_id = l.location_id)\n" +
            "INNER JOIN employees e ON (e.department_id = d.department_id)\n" +
            "GROUP BY l.city\n" +
            "HAVING count(e.employee_id) > 3", nativeQuery = true)
    List<DepartamentoPaisCiudad> obtenerCantidadDepartamentos();
}
