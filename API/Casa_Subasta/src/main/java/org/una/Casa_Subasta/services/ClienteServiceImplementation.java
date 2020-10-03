package org.una.Casa_Subasta.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.Casa_Subasta.entities.Lab2_Cliente;
import org.una.Casa_Subasta.repositories.IClienteRepository;

/**
 *
 * @author Sergio
 */
public class ClienteServiceImplementation implements IClienteService{
    @Autowired
    private IClienteRepository clienteRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Lab2_Cliente>> findAll() {
        return Optional.ofNullable(clienteRepository.findAll());
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Lab2_Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
    
    @Override
    @Transactional
    public Lab2_Cliente create(Lab2_Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    /*@Override
    @Transactional
    public Optional<Lab2_Cliente> update(Lab2_Cliente cliente, Long id) {
        if (clienteRepository.findById(id).isPresent()) {
            return Optional.ofNullable(clienteRepository.save(cliente));
        } else {
            return null;
        }
    } */ 
}
