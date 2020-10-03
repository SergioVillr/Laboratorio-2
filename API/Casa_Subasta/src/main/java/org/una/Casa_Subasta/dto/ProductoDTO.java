package org.una.Casa_Subasta.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 *
 * @author chris
 */
@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class ProductoDTO {
 
    private Long id; 
    private String codigo;   
    private String nombre; 
    private String descripcion; 
    private String fotografia; 
    private boolean estado; 
    private Date fechaRegistro; 
    private Long lotesId; 
     
}

