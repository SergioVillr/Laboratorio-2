/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.Casa_Subasta.controllers;

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
import org.una.Casa_Subasta.dto.PujaDTO;
import org.una.Casa_Subasta.entities.Lab2_Puja;
import org.una.Casa_Subasta.services.IPujaService;
import org.una.Casa_Subasta.utils.MapperUtils;

/**
 *
 * @author chris
 */
@RestController
@RequestMapping("/pujas") 
@Api(tags = {"Puja"})
public class PujaController {

    @Autowired
    private IPujaService pujaService;

    @GetMapping() 
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Lab2_Puja>> result = pujaService.findAll();
            if (result.isPresent()) {
                List<PujaDTO> pujaDTO = MapperUtils.DtoListFromEntityList(result.get(), PujaDTO.class);
                return new ResponseEntity<>(pujaDTO, HttpStatus.OK);
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

            Optional<Lab2_Puja> pujaFound = pujaService.findById(id);
            if (pujaFound.isPresent()) {
                PujaDTO pujaDto = MapperUtils.DtoFromEntity(pujaFound.get(), PujaDTO.class);
                return new ResponseEntity<>(pujaDto, HttpStatus.OK);
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
    public ResponseEntity<?> create(@RequestBody Lab2_Puja puja) {
        try {
            Lab2_Puja pujaCreated = pujaService.create(puja);
            PujaDTO pujaDto = MapperUtils.DtoFromEntity(pujaCreated, PujaDTO.class);
            return new ResponseEntity<>(pujaDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
