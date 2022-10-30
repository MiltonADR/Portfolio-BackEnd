package com.porfolio.mdr.Controller;

import com.porfolio.mdr.Entity.Persona;
import com.porfolio.mdr.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@CrossOrigin(origins= "http://localhost:4200/")
@CrossOrigin(origins = "https://frontendprueba-8403c.web.app")


public class personaController {
    
    @Autowired IPersonaService ipersonaService;
    
    //OBTIENE LA LISTA DE LAS PERSONAS
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
    
        return ipersonaService.getPersona();
    }
    
    
    
    
    //CREA UN OBJETO PERSONA
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    
    public String createPersona(@RequestBody Persona persona){
    
        ipersonaService.savePersona(persona);
        
        return "La persona fue creada correctamente";
    
    }
    
    
    //ELIMINA UN OBJETO PERSONA
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    
    public String deletePersona(@PathVariable Long id){
        
        ipersonaService.deletePersona(id);
        
        return "La persona fue eliminada con exito";
    }
    
    
    //EDITA OBJETO PERSONA
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg){
        
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    

    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
    
    
}
