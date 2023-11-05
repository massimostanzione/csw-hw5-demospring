package it.uniroma2.sc.demospringhibernate.control;

import it.uniroma2.sc.demospringhibernate.bean.PersonaBean;
import it.uniroma2.sc.demospringhibernate.entity.Persona;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Issue #2
 */
public interface IPersonaController  {
    PersonaBean createPersona(PersonaBean p);

    PersonaBean readPersonaById(Long idPersona);

    List<PersonaBean> readAllPersonas();

    void deletePersona(PersonaBean p);

    void deletePersonaById(@NotNull Long idPersona);
}