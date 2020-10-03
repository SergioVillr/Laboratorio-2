/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class PujaDTO {
 
    private Long id; 
    private int cantidad;  
    private boolean estado; 
    private Date fechaRegistro; 
    private Date fechaModificacion; 
    private Long loteId; 
    private Long clienteId; 
     
}

