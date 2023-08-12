package com.Parameta.dto;

import java.util.Date;
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
public class EmpleadoDTO {
    private String Nombres;
    private String Apellidos;
    private String TDocumento;
    private String NDocumento;
    private Date FNacimiento;
    private Date FVinculacion;
    private String Cargo;
    private Double Salario;
    private String TiempoVinculado;
    private String Edad;
    
}
