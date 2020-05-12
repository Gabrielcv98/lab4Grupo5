package com.example.laboratorio4.repository;

import com.example.laboratorio4.dto.TiempoTrabajado;
import com.example.laboratorio4.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {

    @Query(value = "SELECT  e.first_name as nombre, e.last_name as apellido,  jo.job_title as nombrejob, j.start_date as inicio, j.end_date as final,\n" +
            "(datediff(end_date, start_Date) div 365) as cantidadanos, ((datediff(end_date, start_Date) mod 365) div 31) as cantidadmeses\n" +
            " FROM job_history j\n" +
            "inner join employees e on e.employee_id = j.employee_id\n" +
            "inner join jobs jo on jo.job_id = e.job_id\n" +
            "order by cantidadanos desc;" ,nativeQuery = true)
    List<TiempoTrabajado> tiempotrabajado ();

}
