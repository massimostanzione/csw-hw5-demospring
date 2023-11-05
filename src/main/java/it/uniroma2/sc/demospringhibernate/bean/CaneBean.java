package it.uniroma2.sc.demospringhibernate.bean;

import it.uniroma2.sc.demospringhibernate.bean.mapping.Bean;
import lombok.Data;

/**
 * This is a bean for the entity <code>Cane</code>.
 * Attributes could be added/masked/modified... in order to send from/to client/server
 * only what we want it to see.
 */
@Data //Let Lombok manage getters, setters, and so on...
public class CaneBean implements Bean {
    private Long id;
    private String nome;
    private PersonaBean padrone;

    protected CaneBean() {

    }

    public CaneBean(Long id, String nome, PersonaBean padrone) {
        this.id = id;
        this.nome = nome;
        this.padrone = padrone;

    }
}
