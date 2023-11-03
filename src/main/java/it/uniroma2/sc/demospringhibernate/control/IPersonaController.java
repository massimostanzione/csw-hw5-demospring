package it.uniroma2.sc.demospringhibernate.control;

import it.uniroma2.sc.demospringhibernate.entity.Persona;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface IPersonaController  {
    Persona createPersona(Persona p);

    Persona readPersonaById(Long idPersona);

    List<Persona> readAllPersonas();


    void creazioniDiProva();

    void deletePersona(Persona p);

    void deletePersonaById(@NotNull Long idPersona);
}