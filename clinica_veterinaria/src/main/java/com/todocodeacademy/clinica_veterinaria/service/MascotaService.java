package com.todocodeacademy.clinica_veterinaria.service;

import com.todocodeacademy.clinica_veterinaria.dto.MascoDuenioDTO;
import com.todocodeacademy.clinica_veterinaria.model.Mascota;
import com.todocodeacademy.clinica_veterinaria.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService{
    
    
    @Autowired
    private IMascotaRepository repoMasco;
    
     @Override
    public List<Mascota> getMascotas() {
         List<Mascota> listaMascotas = repoMasco.findAll();
        return listaMascotas; 
    }

    @Override
    public void saveMascota(Mascota masco) {
        repoMasco.save(masco);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        repoMasco.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        return repoMasco.findById(id_mascota).orElse(null);
    }

    @Override
    public void editMascota(Mascota masco){
            
            //guardar los cambios
            this.saveMascota(masco);
    }

    @Override
    public List<Mascota> getCaniches() {
        List<Mascota> listaMascotas = this.getMascotas();
        List<Mascota> listaCaniches = new ArrayList<Mascota>();
        
        
        for (Mascota masco:listaMascotas) {
            if (masco.getEspecie().equalsIgnoreCase("perro") && masco.getRaza().equalsIgnoreCase("caniche")) {
                listaCaniches.add(masco);
            }
        }
        return listaCaniches;
    }

    @Override
    public List<MascoDuenioDTO> getMascoDuenios() {
        
        List<Mascota> listaMascotas = this.getMascotas();
        List<MascoDuenioDTO> listaMascoDuenio = new ArrayList<MascoDuenioDTO>();
        MascoDuenioDTO masco_duenio = new MascoDuenioDTO();
        
        for (Mascota masco : listaMascotas) {
            
            System.out.println(masco.getNombre());
            masco_duenio.setNombre_duenio(masco.getDuenio().getNombre());
            masco_duenio.setNombre_mascota(masco.getNombre());
            masco_duenio.setApellido_duenio(masco.getDuenio().getApellido());
            masco_duenio.setEspecie(masco.getEspecie());
            masco_duenio.setRaza(masco.getRaza());
            
            listaMascoDuenio.add(masco_duenio);
            masco_duenio = new MascoDuenioDTO();//reseteo
        }
        return listaMascoDuenio;
    }
    
    
    
}
