package org.una.Casa_Subasta.controllers;

import io.swagger.annotations.Api;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.Casa_Subasta.dto.Lab_2ClienteDTO;
import org.una.Casa_Subasta.entities.Lab2_Cliente;
import org.una.Casa_Subasta.services.ILab2_ClienteService;
import org.una.Casa_Subasta.utils.MapperUtils;

/**
 *
 * @author Sergio
 */
@RestController
@RequestMapping("/lab2_cliente") 
@Api(tags = {"Lab2_Cliente"})
public class Lab2_ClienteController {
    
    @Autowired
    private ILab2_ClienteService lab2_ClienteService;
    
    @GetMapping() 
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Lab2_Cliente>> result = lab2_ClienteService.findAll();
            if (result.isPresent()) {
                List<Lab_2ClienteDTO> clienteDTO = MapperUtils.DtoListFromEntityList(result.get(), Lab_2ClienteDTO.class);
                return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}") 
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Lab2_Cliente> clienteFound = lab2_ClienteService.findById(id);
            if (clienteFound.isPresent()) {
                Lab_2ClienteDTO clienteDTO = MapperUtils.DtoFromEntity(clienteFound.get(), Lab_2ClienteDTO.class);
                return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/") 
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Lab2_Cliente cliente) {
        try {
            Lab2_Cliente clienteCreated = lab2_ClienteService.create(cliente);
            Lab_2ClienteDTO clienteDTO = MapperUtils.DtoFromEntity(clienteCreated, Lab_2ClienteDTO.class);
            return new ResponseEntity<>(clienteDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
