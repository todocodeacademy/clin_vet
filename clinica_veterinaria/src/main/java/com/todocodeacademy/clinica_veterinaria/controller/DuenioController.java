package com.todocodeacademy.clinica_veterinaria.controller;
import com.todocodeacademy.clinica_veterinaria.model.Duenio;
import com.todocodeacademy.clinica_veterinaria.service.IDuenioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DuenioController {
    
     @Autowired
    private IDuenioService duenioServ;
     
      @GetMapping ("/duenio/traer")
    public List<Duenio> getPersonas() {
        
        return duenioServ.getDuenios();
    }
    
    @PostMapping ("/duenio/crear")
    public String savePersona (@RequestBody Duenio duenio) {
        duenioServ.saveDuenio(duenio);
        
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping ("/duenio/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        duenioServ.deleteDuenio(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping ("/duenio/editar")
    public Duenio editPersona(@RequestBody Duenio duenio) {
        duenioServ.editDuenio(duenio);
        
        return duenioServ.findDuenio(duenio.getId_duenio());
    }
    
}
