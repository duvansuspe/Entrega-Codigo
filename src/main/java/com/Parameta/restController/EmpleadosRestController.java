package com.Parameta.restController;

import com.Parameta.dto.Response;
import com.Parameta.entity.Empleados;
import com.Parameta.service.ServiceEmpleado;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author worker3
 */
@RestController
@RequestMapping("/empleado")
public class EmpleadosRestController {
    @Autowired
    private ServiceEmpleado servicioEmpleado;   
    // Para listar
    @GetMapping
    public List<Empleados> findAll(){
        return servicioEmpleado.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Empleados> findById(@PathVariable("id") Long id){
        return servicioEmpleado.findById(id);
    }
    
    @PostMapping
    /*public List<Empleados> add( @RequestBody Empleados e){
        return servicioEmpleado.agregarEmpleado(e);
    }*/
    public Response add( @RequestBody Empleados e){
        return servicioEmpleado.agregarEmpleado(e);
    }
}
