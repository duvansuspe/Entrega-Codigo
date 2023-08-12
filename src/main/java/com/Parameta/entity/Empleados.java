package com.Parameta.entity;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author worker3
 */
//Imvocar a lombok o clase constructora
@Builder
// para crear el constructor con parametros
@AllArgsConstructor
// para crear el constructor sin parametros
@NoArgsConstructor
//Agregar metodo get y set
@Data
@Entity(name = "Empleados")
@Table(name = "empleado")
public class Empleados implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "Nombres")
    private String Nombres;
    @Column (name = "Apellidos")
    private String Apellidos;
    @Column (name = "T_Documento")
    private String TDocumento;
    @Column (name = "Num_Documento")
    private String NDocumento;
    @Column (name = "Fecha_Nacimiento")
    private Date FNacimiento;
    @Column (name = "Fecha_Vinculacion")
    private Date FVinculacion;
    @Column (name = "Cargo")
    private String Cargo;
    @Column (name = "Salario")
    private Double Salario;
}
