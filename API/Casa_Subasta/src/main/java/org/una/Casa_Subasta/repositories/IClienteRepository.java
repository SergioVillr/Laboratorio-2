package org.una.Casa_Subasta.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.Casa_Subasta.entities.Lab2_Cliente;

/**
 *
 * @author Sergio
 */
public interface IClienteRepository extends JpaRepository<Lab2_Cliente, Long> {

     public Optional<Lab2_Cliente> findById(Long id);
     
     public List<Lab2_Cliente> findByNombre(String nombre);
     
     public List<Lab2_Cliente> findByCorreoelectronico(String password);

    
    
//        @Query("select u from Usuario u where UPPER(u.nombreCompleto) like CONCAT('%',UPPER(:nombreCompleto),'%')\"") 
//        public Usuario findNombreCompletoWithLikeSQL(@Param("nombreCompleto")String nombreCompleto);

 
}

