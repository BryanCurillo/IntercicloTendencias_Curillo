/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interciclo.m5a.empleado.controller;

import com.interciclo.m5a.empleado.model.Empleado;
import com.interciclo.m5a.empleado.service.EmpleadoServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bryan
 */
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoServiceImpl serviceImpl;

//    @Operation(summary = "Se obtiene la lista de empleados")
    @GetMapping("/get")
    public ResponseEntity<List<Empleado>> listar() {
        return new ResponseEntity<>(serviceImpl.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Empleado> crear(@RequestBody Empleado e) {
        double sueldo = e.getDias_trabajo() * 15;
        if (e.getDias_trabajo() > 0) {
            if (e.getDias_trabajo() >= 20 && e.getDias_trabajo() < 30) {
                sueldo = sueldo + sueldo * 0.02;
            }

            if (e.getDias_trabajo() >= 30) {
                sueldo = sueldo + sueldo * 0.05;
            }
            
            e.setSueldo(sueldo);
            return new ResponseEntity<>(serviceImpl.save(e), HttpStatus.CREATED);

        } else {
            System.out.println("LOS DIAS DE TRABAJO DEBEN SER MAYOR A 0");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable Integer id, @RequestBody Empleado e) {
        Empleado empleado = serviceImpl.findById(id);

        if (empleado != null) {
            empleado.setApellido(e.getApellido());
            empleado.setDias_trabajo(e.getDias_trabajo());
            empleado.setDireccion(e.getDireccion());
            empleado.setFecha_nacimiento(e.getFecha_nacimiento());
            empleado.setNombre(e.getNombre());
            empleado.setObservacion(e.getObservacion());
            empleado.setSueldo(e.getSueldo());
            empleado.setTelefono(e.getTelefono());
            return new ResponseEntity<>(serviceImpl.save(empleado), HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Empleado> elimiar(@PathVariable Integer id) {
        serviceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
