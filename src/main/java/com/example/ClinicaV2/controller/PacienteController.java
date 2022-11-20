package com.example.ClinicaV2.controller;

import com.example.ClinicaV2.model.Odontologo;
import com.example.ClinicaV2.model.Paciente;
import com.example.ClinicaV2.services.OdontologoService;
import com.example.ClinicaV2.services.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PacienteController {

    private final PacienteService service;

    @GetMapping("/pacientes")
    public void searchAll (){
        service.serachAll();
    }

    @PostMapping("/nuevosPacientes")
    public void add(@RequestParam Paciente paciente){
        if (paciente != null){
            service.add(paciente);
        }
    }

    @PutMapping("/modificarPaciente")
    public void update (@RequestParam Paciente paciente, Long id){
        service.updatePaciente(paciente,id);
    }

    @DeleteMapping("/eliminarPaciente")
    public void remove (@RequestParam Long id){
        service.remove(id);
    }

    @GetMapping("/pacientes/{id}")
    public void searchPaciente (@PathVariable Long id) {
        service.searchPaciente(id);
    }
}
