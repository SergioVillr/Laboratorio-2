package org.una.Casa_Subasta.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.Casa_Subasta.entities.Lab2_Puja;
import org.una.Casa_Subasta.repositories.IPujaRepository;

/**
 *
 * @author chris
 */
@Service
public class PujaServiceImplementation implements IPujaService {

    @Autowired
    private IPujaRepository pujaRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Lab2_Puja>> findAll() {
        return Optional.ofNullable(pujaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Lab2_Puja> findById(Long id) {
        return pujaRepository.findById(id);
    }
    
    @Override
    @Transactional
    public Lab2_Puja create(Lab2_Puja puja) {
        return pujaRepository.save(puja);
    }
}

