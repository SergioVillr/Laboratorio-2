package org.una.Casa_Subasta.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.Casa_Subasta.entities.Lab2_Lote;
import org.una.Casa_Subasta.repositories.ILoteRepository;

/**
 *
 * @author Sergio
 */
public class LoteServiceImplementation implements ILoteService{
    
    @Autowired
    private ILoteRepository lotesRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Lab2_Lote>> findAll() {
        return Optional.ofNullable(lotesRepository.findAll());
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Lab2_Lote> findById(Long id) {
        return lotesRepository.findById(id);
    }
    
    @Override
    @Transactional
    public Lab2_Lote create(Lab2_Lote productos) {
        return lotesRepository.save(productos);
    }
    
   /*@Override
    @Transactional
    public Optional<Lab2_Lote> update(Lab2_Lote lote, Long id) {
        if (lotesRepository.findById(id).isPresent()) {
            return Optional.ofNullable(lotesRepository.save(lote));
        } else {
            return null;
        }
    }*/
}
