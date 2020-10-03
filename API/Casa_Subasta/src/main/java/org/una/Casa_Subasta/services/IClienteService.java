package org.una.Casa_Subasta.services;

import java.util.List;
import java.util.Optional;
import org.una.Casa_Subasta.entities.Lab2_Cliente;

/**
 *
 * @author Sergio
 */
public interface IClienteService {
    
    public Optional<Lab2_Cliente> findById(Long id);
    
    public Optional<List<Lab2_Cliente>> findAll();
    
    public Lab2_Cliente create(Lab2_Cliente cliente);

   // public Optional<Lab2_Cliente> update(Lab2_Cliente cliente, Long id);
    
    
}
