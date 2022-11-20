package com.example.ClinicaV2.services;

import com.example.ClinicaV2.model.Odontologo;
import com.example.ClinicaV2.model.Paciente;
import com.example.ClinicaV2.repository.Dao;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    private Dao<Paciente> pacienteDAO;

    public Paciente add(Paciente paciente) {
        return pacienteDAO.add(paciente);
    };

    public void remove(Long id){
        pacienteDAO.remove(id);
    };

    public Paciente updatePaciente(Paciente paciente, Long id){
        return pacienteDAO.update(paciente, id);
    };

    public void searchPaciente(Long id){
        pacienteDAO.search(id);
    };

    public void serachAll(){
        pacienteDAO.serachAll();
    };
}
