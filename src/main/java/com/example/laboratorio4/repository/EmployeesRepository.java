package com.example.laboratorio4.repository;

import com.example.laboratorio4.dto.EmpleadoMayorSalDto;
import com.example.laboratorio4.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {

    @Query(value = "select e.first_name as nombre, e.last_name as apellido, jh.start_date as fechainicio, jh.end_date as fechafin, j.job_title as puesto\n" +
            "from job_history jh\n" +
            "join employees e on (jh.employee_id= e.employee_id)\n" +
            "join jobs j on (e.job_id=j.job_id)\n" +
            "where e.salary > 8000;" ,nativeQuery = true)
    List<EmpleadoMayorSalDto> empleadoMayor ();

    @Query(value = "(select e.first_name as nombre, e.last_name as apellido, jh.start_date as fechainicio, jh.end_date as fechafin, j.job_title as puesto\n" +
            "from job_history jh\n" +
            "join employees e on (jh.employee_id= e.employee_id)\n" +
            "join jobs j on (e.job_id=j.job_id)\n" +
            "where e.salary > ?1);" ,nativeQuery = true)
    List<EmpleadoMayorSalDto> obtenerFiltroEmpleado (int busqueda);


}
