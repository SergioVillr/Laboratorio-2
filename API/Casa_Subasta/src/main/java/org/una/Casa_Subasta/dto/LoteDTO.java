package org.una.Casa_Subasta.dto;


import java.sql.Time;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Sergio
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class LoteDTO {
 
    private Long id; 
    private String nombreCatalogo;   
    private float preciosalida; 
    private double mayorpuja;
    private int horasubasta;
    private Time horainicio;
    private boolean estado; 
    private Date fechaRegistro;
     
}

