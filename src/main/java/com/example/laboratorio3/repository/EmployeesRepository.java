package com.example.laboratorio3.repository;


import com.example.laboratorio3.dto.EmpleadosSalarioMayor;
import com.example.laboratorio3.dto.GerentesConExperiencia;
import com.example.laboratorio3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    @Query(value = "select first_name , e.last_name, jh.start_date, jh.end_date, j.job_title , e.salary\n" +
            "from employees e\n" +
            "inner join job_history jh on e.employee_id = jh.employee_id\n" +
            "inner join jobs j on e.job_id = j.job_id\n" +
            "where e.salary>1500", nativeQuery = true)
    List<EmpleadosSalarioMayor> obtenerEmpleadoSalario();

    @Query(value = "select e.* from employees e\n" +
            "left join jobs j on e.job_id = j.job_id\n" +
            "left join departments d on e.department_id = d.department_id\n" +
            "left join locations l on d.location_id = l.location_id\n" +
            "where e.first_name like %?1% or e.last_name like %?1%\n" +
            "or j.job_title like %?1% or d.department_name like %?1% or l.city like %?1%",
            nativeQuery = true)
    List<Employees> buscarInputBuscador(String inputIngresado);

    @Query(value = "select d.department_name, m.first_name, m.last_name, m.salary from departments d\n" +
            "left join employees m on m.employee_id = d.manager_id\n" +
            "where DATE_SUB(now(), INTERVAL 5 year)>=m.hire_date", nativeQuery = true)
    List<GerentesConExperiencia> obtenerGerentes();

}
