package com.example.ClinicaV2.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class Paciente {
    //attributes
    private Long id;
    private String nombre, apellido, email, dni;
    private LocalDate fechaIngreso;

    //constructor


    public Paciente(String nombre, String apellido, String email, String dni, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
    }
}
