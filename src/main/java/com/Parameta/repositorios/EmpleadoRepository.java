package com.Parameta.repositorios;

import com.Parameta.entity.Empleados;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author worker3
 */
public interface EmpleadoRepository extends JpaRepository<Empleados, Long>{
    //Agregar consultas sql
    @Query("select e from Empleados e where e.id='1'")
    List<Empleados> findAllCustom();
}
