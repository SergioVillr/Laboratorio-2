package org.una.Casa_Subasta.services;

import java.util.List;
import java.util.Optional;
import org.una.Casa_Subasta.entities.Lab2_Lote;

/**
 *
 * @author Sergio
 */
public interface ILoteService {
    
    public Optional<List<Lab2_Lote>> findAll();

    public Optional<Lab2_Lote> findById(Long id);
    
    public Lab2_Lote create(Lab2_Lote lotes);

   // public Optional<Lab2_Lote> update(Lab2_Lote lotes, Long id);


}
