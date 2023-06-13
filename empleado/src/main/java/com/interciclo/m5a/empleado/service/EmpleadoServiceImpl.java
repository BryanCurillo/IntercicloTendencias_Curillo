/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interciclo.m5a.empleado.service;

import com.interciclo.m5a.empleado.model.Empleado;
import com.interciclo.m5a.empleado.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bryan
 */
@Service
public class EmpleadoServiceImpl extends GenericServiceImpl<Empleado, Integer> implements GenericService<Empleado, Integer>{

    @Autowired
    EmpleadoRepository repository;
    
    @Override
    public CrudRepository<Empleado, Integer> getDao() {
        return repository;
    }
    
}
