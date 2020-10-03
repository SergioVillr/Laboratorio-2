package org.una.Casa_Subasta.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.Casa_Subasta.entities.Lab2_Producto;
/**
 *
 * @author chris
 */
public interface IProductoRepository extends JpaRepository<Lab2_Producto, Long> {

    public List<Lab2_Producto> findByCodigo(String codigo);

    public List<Lab2_Producto> findByNombre(String nombre);

    public Optional<List<Lab2_Producto>> findByLoteId(Long id);
}

