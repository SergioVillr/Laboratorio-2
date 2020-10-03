/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.una.Casa_Subasta.dto.ProductoDTO;
import org.una.Casa_Subasta.entities.Lab2_Producto;
import org.una.Casa_Subasta.services.IProductoService;
import org.una.Casa_Subasta.utils.MapperUtils;

/**
 *
 * @author chris
 */
@RestController
@RequestMapping("/productos") 
@Api(tags = {"Producto"})
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping() 
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Lab2_Producto>> result = productoService.findAll();
            if (result.isPresent()) {
                List<ProductoDTO> productoDTO = MapperUtils.DtoListFromEntityList(result.get(), ProductoDTO.class);
                return new ResponseEntity<>(productoDTO, HttpStatus.OK);
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

            Optional<Lab2_Producto> productoFound = productoService.findById(id);
            if (productoFound.isPresent()) {
                ProductoDTO productoDto = MapperUtils.DtoFromEntity(productoFound.get(), ProductoDTO.class);
                return new ResponseEntity<>(productoDto, HttpStatus.OK);
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
    public ResponseEntity<?> create(@RequestBody Lab2_Producto producto) {
        try {
            Lab2_Producto productoCreated = productoService.create(producto);
            ProductoDTO productoDto = MapperUtils.DtoFromEntity(productoCreated, ProductoDTO.class);
            return new ResponseEntity<>(productoDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}