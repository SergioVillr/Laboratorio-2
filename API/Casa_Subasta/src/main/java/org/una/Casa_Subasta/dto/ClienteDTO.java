package org.una.Casa_Subasta.dto;

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
public class ClienteDTO {
    private String nombreCatalogo;
    private String nombreusuario;
    private String password;
    private String correoelectronico;
    private Date fechaRegistro;
    private boolean estado;
}
