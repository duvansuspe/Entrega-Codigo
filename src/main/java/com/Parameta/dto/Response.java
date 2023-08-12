package com.Parameta.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author worker3
 */
@Builder
@AllArgsConstructor
// para crear el constructor sin parametros
@NoArgsConstructor
//Agregar metodo get y set
@Data
public class Response {
    private String mensaje;
    private List<EmpleadoDTO> empleados;
    
}
