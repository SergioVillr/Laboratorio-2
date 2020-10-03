package org.una.Casa_Subasta.services;

import java.util.List;
import java.util.Optional;
import org.una.Casa_Subasta.entities.Lab2_Lotes;

/**
 *
 * @author Sergio
 */
public interface ILoteService {
    
    public Optional<List<Lab2_Lotes>> findAll();

    public Optional<Lab2_Lotes> findById(Long id);
    
    public Lab2_Lotes create(Lab2_Lotes lotes);

    public Optional<Lab2_Lotes> update(Lab2_Lotes lotes, Long id);


}
