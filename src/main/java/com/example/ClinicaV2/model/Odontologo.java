package com.example.ClinicaV2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Odontologo {
    //attributes
    private Long ID;
    private String nombre, apellido;
    private Long matricula;

    //constructor


    public Odontologo(String nombre, String apellido, Long matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
