package com.example.laboratorio3.repository;


import com.example.laboratorio3.dto.EmpleadosSalarioMayor;
import com.example.laboratorio3.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    @Query(value = "select first_name as firstname, e.last_name as lastname, jh.start_date as startdate, jh.end_date as enddate, j.job_title as jobtitle \n" +
            "from employees e\n" +
            "inner join job_history jh on e.employee_id = jh.employee_id\n" +
            "inner join jobs j on e.job_id = j.job_id\n" +
            "where e.salary>1500", nativeQuery = true)
    List<EmpleadosSalarioMayor> obtenerEmpleadoSalario();

}
