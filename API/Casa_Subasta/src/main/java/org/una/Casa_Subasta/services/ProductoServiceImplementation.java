package org.una.Casa_Subasta.services;

import org.una.Casa_Subasta.entities.Lab2_Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.Casa_Subasta.repositories.IProductoRepository;

/**
 *
 * @author chris
 */
@Service
public class ProductoServiceImplementation implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Lab2_Producto>> findAll() {
        return Optional.ofNullable(productoRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Lab2_Producto> findById(Long id) {
        return productoRepository.findById(id);
    }
    
    @Override
    @Transactional
    public Lab2_Producto create(Lab2_Producto productos) {
        return productoRepository.save(productos);
    }
}

