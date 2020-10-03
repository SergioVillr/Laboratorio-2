package org.una.Casa_Subasta.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.Casa_Subasta.entities.Lab2_Lotes;
/**
 *
 * @author Sergio
 */
public interface ILotesRepository extends JpaRepository<Lab2_Lotes, Long>  {
    
    public Optional<Lab2_Lotes> findById(Long id);
}
