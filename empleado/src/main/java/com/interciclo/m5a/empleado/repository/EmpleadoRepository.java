/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.interciclo.m5a.empleado.repository;

import com.interciclo.m5a.empleado.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Bryan
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query(value = "Select * from empleado e where e.nombre = :nombre", nativeQuery = true)
    public Empleado buscarnombre(String nombre);
}
