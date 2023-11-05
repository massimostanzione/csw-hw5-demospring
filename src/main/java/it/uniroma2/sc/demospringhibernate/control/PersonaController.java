package it.uniroma2.sc.demospringhibernate.control;

import it.uniroma2.sc.demospringhibernate.bean.PersonaBean;
import it.uniroma2.sc.demospringhibernate.bean.mapping.CaneMapper;
import it.uniroma2.sc.demospringhibernate.bean.mapping.PersonaMapper;
import it.uniroma2.sc.demospringhibernate.dao.PersonaDao;
import it.uniroma2.sc.demospringhibernate.entity.Cane;
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

    private PersonaMapper mapper=new PersonaMapper();

    /**
     * FIXME, see issue #4
     */
    //private DTOMapper<Persona, PersonaBean> mapper=new DTOMapper<>();

    @Override
    public PersonaBean createPersona(PersonaBean p) {
        personaDao.save(this.mapper.toEntity(p));
        return p; // it is already a bean
    }

    /**
     * Oss.: il tipo di ritorno getOne vs. findById (Optional)
     *
     * @param idPersona
     * @return
     */
    @Override
    public PersonaBean readPersonaById(@NotNull Long idPersona) {
        Persona retrievedPersona=personaDao.getOne(idPersona);
        return this.mapper.toBean(retrievedPersona);
    }

    @Override
    public List<PersonaBean> readAllPersonas() {
        List<Persona> retrievedPersonaList = personaDao.findAll();
        return this.mapper.toBeanList(retrievedPersonaList);
    }

    @Override
    public void deletePersona(PersonaBean p) {
        personaDao.delete(this.mapper.toEntity(p));
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