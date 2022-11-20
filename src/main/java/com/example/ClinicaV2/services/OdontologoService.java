package com.example.ClinicaV2.services;

import com.example.ClinicaV2.model.Odontologo;
import com.example.ClinicaV2.repository.Dao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OdontologoService {
    private Dao<Odontologo> odontologoDAO;

    public Odontologo add(Odontologo odon) {
        return odontologoDAO.add(odon);
    };

    public void remove(Long id){
        odontologoDAO.remove(id);
    };

    public Odontologo updateOdontologo(Odontologo ondontologo, Long id){
        return odontologoDAO.update(ondontologo, id);
    };

    public void searchOdontologo(Long id){
        odontologoDAO.search(id);
    };

    public void serachAll(){
        odontologoDAO.serachAll();
    };
}
