package com.example.laboratorio3.repository;


import com.example.laboratorio3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    @Query(value = "select e.* from employees e\n" +
            "left join jobs j on e.job_id = j.job_id\n" +
            "left join departments d on e.department_id = d.department_id\n" +
            "left join locations l on d.location_id = l.location_id\n" +
            "where e.first_name like %?1% or e.last_name like %?1%\n" +
            "or j.job_title like %?1% or d.department_name like %?1% or l.city like %?1%;",
            nativeQuery = true)
    List<Employees> buscarInputBuscador(String inputIngresado);

}
