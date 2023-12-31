package it.uniroma2.sc.demospringhibernate.bean.mapping;

import it.uniroma2.sc.demospringhibernate.bean.IndirizzoBean;
import it.uniroma2.sc.demospringhibernate.bean.PersonaBean;
import it.uniroma2.sc.demospringhibernate.entity.Persona;

import java.util.ArrayList;
import java.util.List;

/**
 * A <i>naive</i> implementation of a entity/bean mapper for <code>Persona</code> class.
 *
 * See <code>DTOMapper</code> and issue #4 for a more <i>generic</i> implementation.
 *
 * @see DTOMapper
 */
public class PersonaMapper {
    //TODO i costruttori NON prevedono parametri per titoli di studio, altri cani ecc.
    //... per questo non realizzati relativi mapper
    // inoltre sfruttare ObjectMapper, v. Issue #4
    private IndirizzoMapper indirizzoMapper=new IndirizzoMapper();
    public Persona toEntity(PersonaBean b) {
        return new Persona(b.getNome(),b.getCognome(),indirizzoMapper.toEntity(b.getIndirizzo()));
    }

    public List<Persona> toEntityList(List<PersonaBean> l) {
        List<Persona> ret = new ArrayList<>();
        for (PersonaBean b : l) {
            ret.add(this.toEntity(b));
        }
        return ret;
    }

    public PersonaBean toBean(Persona e) {
        return new PersonaBean(e.getNome(),e.getCognome(),indirizzoMapper.toBean(e.getIndirizzo()));
    }

    public List<PersonaBean> toBeanList(List<Persona> l) {
        List<PersonaBean> ret = new ArrayList<>();
        for (Persona e : l) {
            ret.add(this.toBean(e));
        }
        return ret;
    }
}
