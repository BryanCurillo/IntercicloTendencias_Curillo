/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interciclo.m5a.empleado.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Bryan
 */
@Data
@Entity

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int id_empleado;

//    @NotBlank(message = "Ingrese el apellido del empleado")
    @Size(max = 45, message = "Longitud maxima de 45 caracteres")
    @Column(name = "apellido")
    private String apellido;

//    @NotBlank(message = "Ingrese el nombre del empleado")
    @Size(max = 45, message = "Longitud maxima de 45 caracteres")
    @Column(name = "nombre")
    private String nombre;

//    @NotBlank(message = "Ingrese el telefono del empleado")
    @Size(max = 15, message = "Longitud maxima de 15 caracteres")
    @Column(name = "telefono")
    private String telefono;

//    @NotBlank(message = "Ingrese  del la direccion del empleado")
    @Size(max = 45, message = "Longitud maxima de 45 caracteres")
    @Column(name = "direccion")
    private String direccion;

//    @NotBlank(message = "Ingrese la fecha de nacimiento del empleado")
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

//    @Size(max = 45, message = "Longitud maxima de 45 caracteres")
    @Column(name = "observacion")
    private String observacion;

    @Column(name = "dias_trabajo")
    private int dias_trabajo;

//    @DecimalMin(value = "1.0", inclusive = false)
//    @Digits(integer=1, fraction=2)
    @Column(name = "sueldo")
    private double sueldo;
}
