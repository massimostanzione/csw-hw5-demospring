package it.uniroma2.sc.demospringhibernate.control;

import it.uniroma2.sc.demospringhibernate.dao.PersonaDao;
import it.uniroma2.sc.demospringhibernate.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Issue #2
 */
@Service
public class PersonaController implements IPersonaController {
    @Autowired
    private PersonaDao personaDao;

    @Override
    public Persona createPersona(Persona p) {
        return personaDao.save(p);
    }

    /**
     * Oss.: il tipo di ritorno getOne vs. findById (Optional)
     *
     * @param idPersona
     * @return
     */
    @Override
    public Persona readPersonaById(@NotNull Long idPersona) {
        return personaDao.getOne(idPersona);
    }

    @Override
    public List<Persona> readAllPersonas() {
        return personaDao.findAll();
    }

    @Override
    public void creazioniDiProva() {
        //TODO
    }

    @Override
    public void deletePersona(Persona p) {
        personaDao.delete(p);
    }

    /**
     * Oss.: è stato necessario riferire cascade, v. Persona:38
     * @param idPersona
     * @see Persona
     */
    @Override
    public void deletePersonaById(@NotNull Long idPersona) {
        personaDao.deleteById(idPersona);
    }
}