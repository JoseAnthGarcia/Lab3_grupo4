package com.example.laboratorio3.repository;

import com.example.laboratorio3.entity.Employees;
import com.example.laboratorio3.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {


    @Query(value = "select h.*\n" +
            "from job_history h\n" +
            "left join employees e on h.employee_id = e.employee_id\n" +
            "left join jobs j on h.job_id = j.job_id\n" +
            "left join departments d on h.department_id = d.department_id\n" +
            "left join locations l on d.location_id = l.location_id\n" +
            "where e.first_name like %?1% or e.last_name like %?1%\n" +
            "or j.job_title like %?1% or d.department_name like %?1%",
            nativeQuery = true)
    List<History> buscarInputBuscador(String inputIngresado);

}
