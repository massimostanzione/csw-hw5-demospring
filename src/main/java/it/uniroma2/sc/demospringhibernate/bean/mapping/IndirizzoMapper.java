package it.uniroma2.sc.demospringhibernate.bean.mapping;

import it.uniroma2.sc.demospringhibernate.bean.IndirizzoBean;
import it.uniroma2.sc.demospringhibernate.entity.Indirizzo;

import java.util.ArrayList;
import java.util.List;

public class IndirizzoMapper {
    public Indirizzo toEntity(IndirizzoBean b) {
        return new Indirizzo(b.getViaENumero(),b.getCap());
    }

    public List<Indirizzo> toEntityList(List<IndirizzoBean> l) {
        List<Indirizzo> ret = new ArrayList<>();
        for (IndirizzoBean b : l) {
            ret.add(this.toEntity(b));
        }
        return ret;
    }

    public IndirizzoBean toBean(Indirizzo e) {
        return new IndirizzoBean(e.getViaENumero(),e.getCap());
    }

    public List<IndirizzoBean> toBeanList(List<Indirizzo> l) {
        List<IndirizzoBean> ret = new ArrayList<>();
        for (Indirizzo e : l) {
            ret.add(this.toBean(e));
        }
        return ret;
    }
}
