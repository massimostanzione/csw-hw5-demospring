package it.uniroma2.sc.demospringhibernate.bean;

import it.uniroma2.sc.demospringhibernate.entity.Citta;
import lombok.Data;

import javax.persistence.Embedded;

/**
 * This is a bean for the entity <code>Indirizzo</code>.
 * Attributes could be added/masked/modified... in order to send from/to client/server
 * only what we want it to see.
 */
@Data //Let Lombok manage getters, setters, and so on...
public class IndirizzoBean {
    private Long id;
    private String viaENumero;
    private String cap;
    private CittaBean citta;

    protected IndirizzoBean() {

    }

    public IndirizzoBean(String viaENumero, String cap) {
        this.viaENumero = viaENumero;
        this.cap = cap;
    }
}
