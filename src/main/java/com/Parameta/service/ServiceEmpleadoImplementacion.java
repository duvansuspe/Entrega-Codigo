package com.Parameta.service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.Parameta.dto.EmpleadoDTO;
import com.Parameta.dto.Response;
import com.Parameta.entity.Empleados;
import com.Parameta.repositorios.EmpleadoRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author worker3
 */
@Service
public class ServiceEmpleadoImplementacion implements ServiceEmpleado{
    //poder inyectar las dependencias
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleados> findAll() {
        //para buscar todo
        return empleadoRepository.findAll();
    }

    @Override
    public List<Empleados> findAllCustom() {
        return empleadoRepository.findAllCustom();
    }

    @Override
    public Optional<Empleados> findById(long id) {
        return empleadoRepository.findById(id);
    }
    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/DD");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
    public Response agregarEmpleado(Empleados e) {   
        boolean res = true;
        Response response = new Response();
        Date fecha = new Date();
        fecha.equals(e.getFNacimiento());
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/DD");
        String fechaStr = formato.format(fecha);
        res = validarFecha(fechaStr);
        if (e.getNombres() == null || e.getNombres().isEmpty() || e.getApellidos()== null || e.getApellidos().isEmpty() || e.getTDocumento() == null || e.getTDocumento().isEmpty() ||
            e.getNDocumento() == null || e.getNDocumento().isEmpty() || e.getFNacimiento() == null || e.getFVinculacion() == null ||
            e.getCargo() == null || e.getCargo().isEmpty() || e.getSalario() == null || e.getSalario() == null && res == true) {
            response.setMensaje("Todossssss los campos deben ser completados");
            
        }else{ 
            if(res == true){
                LocalDate fechaVin = e.getFVinculacion().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate fechaNac = e.getFNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate ahora = LocalDate.now();
                Period vinculacion = Period.between(fechaVin, ahora);
                Period diferencia = Period.between(fechaNac, ahora);
                if (diferencia.getYears() >= 18){
                    empleadoRepository.save(e);
                    List<Empleados> empleados = empleadoRepository.findAll();
                    List<EmpleadoDTO> empleadoDTO =new ArrayList<EmpleadoDTO>(); 
                    for (int i = 0; i < empleados.size(); i++) {
                        EmpleadoDTO empl1 = new EmpleadoDTO();
                        empl1.setNombres(empleados.get(i).getNombres());
                        empl1.setApellidos(empleados.get(i).getApellidos());
                        empl1.setTDocumento(empleados.get(i).getTDocumento());
                        empl1.setNDocumento(empleados.get(i).getNDocumento());
                        empl1.setFNacimiento(empleados.get(i).getFNacimiento());
                        empl1.setFVinculacion(empleados.get(i).getFVinculacion());
                        empl1.setCargo(empleados.get(i).getCargo());
                        empl1.setSalario(empleados.get(i).getSalario());
                        empl1.setTiempoVinculado("El tiempo de servicio es: " + vinculacion.getYears() + " años " + vinculacion.getMonths() + " meses");
                        empl1.setEdad("La edad es: " + diferencia.getYears() + " años " + diferencia.getMonths() + " meses y " + diferencia.getDays() + " días");
                        empleadoDTO.add(empl1);
                    }
                    response.setEmpleados(empleadoDTO);
                }else {
                    response.setMensaje("El empleado es menor de edad y no se puede registrar.");
                }
            }else {
                response.setMensaje("El formato fecha no es correcto.");
            }
        }
        return response;
    }
    
}
