package com.todocodeacademy.clinica_veterinaria.service;
import com.todocodeacademy.clinica_veterinaria.model.Duenio;
import com.todocodeacademy.clinica_veterinaria.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenioService implements IDuenioService{

     @Autowired
    private IDuenioRepository repoDuenio;

    @Override
    public List<Duenio> getDuenios() {
        List<Duenio> listaDuenios = repoDuenio.findAll();
        return listaDuenios;
    }

    @Override
    public void saveDuenio(Duenio duenio) {
        repoDuenio.save(duenio);
    }

    @Override
    public void deleteDuenio(Long id) {
        repoDuenio.deleteById(id);
    }

    @Override
    public Duenio findDuenio(Long id) {
        return repoDuenio.findById(id).orElse(null);
    }

    @Override
    public void editDuenio(Duenio duenio) {
        this.saveDuenio(duenio);
    }
    
    
    
}
