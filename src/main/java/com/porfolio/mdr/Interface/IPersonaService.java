package com.porfolio.mdr.Interface;

import com.porfolio.mdr.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    //TRAER UNA LISTA PERSONA
    
    public List<Persona> getPersona();
    
    //GUARDAR UN OBJETO DE TIPO PERSONA
    
    public void savePersona(Persona persona);
    
    //ELIMINAR UN OBJETO PERO LO BUSCAMOS POR ID
    
    public void deletePersona(Long id);
    
    //BUSCAR UNA PERSONA POR ID
    
    public Persona findPersona(Long id);
    
}
