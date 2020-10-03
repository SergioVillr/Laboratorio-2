package org.una.Casa_Subasta.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.Casa_Subasta.entities.Lab2_Lote;
/**
 *
 * @author Sergio
 */
public interface ILoteRepository extends JpaRepository<Lab2_Lote, Long>  {
    
    public Optional<Lab2_Lote> findById(Long id);
    
    public List<Lab2_Lote> findByNombre(String nombreCatalogo);
    
    public List<Lab2_Lote> findByHoraSubasta(int horasubasta);
    
    
}
