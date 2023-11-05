package it.uniroma2.sc.demospringhibernate.bean.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.uniroma2.sc.demospringhibernate.bean.CaneBean;
import it.uniroma2.sc.demospringhibernate.entity.Cane;

import java.util.ArrayList;
import java.util.List;

/**
 * A <i>naive</i> implementation of a entity/bean mapper for <code>Cane</code> class.
 */
public class CaneMapper {
    private PersonaMapper personaMapper=new PersonaMapper();
    public Cane toEntity(CaneBean b) {
        return new Cane(b.getNome(),personaMapper.toEntity(b.getPadrone()));
    }

    public List<Cane> toEntityList(List<CaneBean> l) {
        List<Cane> ret = new ArrayList<>();
        for (CaneBean b : l) {
            ret.add(this.toEntity(b));
        }
        return ret;
    }

    public CaneBean toBean(Cane e) {
        return new CaneBean(e.getId(), e.getNome(),personaMapper.toBean(e.getPadrone()));
    }

    public List<CaneBean> toBeanList(List<Cane> l) {
        List<CaneBean> ret = new ArrayList<>();
        for (Cane e : l) {
            ret.add(this.toBean(e));
        }
        return ret;
    }
}
