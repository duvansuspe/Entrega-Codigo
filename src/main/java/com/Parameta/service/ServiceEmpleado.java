package com.Parameta.service;

import com.Parameta.dto.Response;
import com.Parameta.entity.Empleados;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author worker3
 */
public interface ServiceEmpleado {
    // muestra todo
    public List<Empleados> findAll();
    // Solo los listados
    public List<Empleados> findAllCustom();
    //buscar por codigo
    public Optional<Empleados> findById(long id);
    //Agregar empleado
    //public Empleados add(Empleados e);
    public Response agregarEmpleado(Empleados e);
    //public List<Empleados> agregarEmpleado(Empleados e);
}
