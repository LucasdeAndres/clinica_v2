package com.example.ClinicaV2.controller;

import com.example.ClinicaV2.model.Odontologo;
import com.example.ClinicaV2.services.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class OdontologoController {

    private final OdontologoService service;

    public OdontologoController(OdontologoService service) {
        this.service = service;
    }
    @GetMapping("/odontologos")
    public void searchAll (){
        service.serachAll();
    }

    @PostMapping("/nuevosOdontologos")
    public void add(@RequestParam Odontologo odontologo){
        if (odontologo != null){
            service.add(odontologo);
        }
    }

    @PutMapping("/modificarOdontologo")
    public void update (@RequestParam Odontologo odontologo, Long id){
        service.updateOdontologo(odontologo,id);
    }

    @DeleteMapping("/eliminarOdontologo")
    public void remove (@RequestParam Long id){
        service.remove(id);
    }

    @GetMapping("/odontologos/{id}")
    public void searchOdontologo (@PathVariable Long id){
        service.searchOdontologo(id);
    }

}
