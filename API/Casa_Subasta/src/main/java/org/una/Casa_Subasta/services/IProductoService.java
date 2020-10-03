/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Casa_Subasta.services;

import java.util.List;
import java.util.Optional;
import org.una.Casa_Subasta.entities.Lab2_Producto;

/**
 *
 * @author chris
 */
public interface IProductoService {

    public Optional<List<Lab2_Producto>> findAll();

    public Optional<Lab2_Producto> findById(Long id);
    
    public Lab2_Producto create(Lab2_Producto lotes);
    
}

