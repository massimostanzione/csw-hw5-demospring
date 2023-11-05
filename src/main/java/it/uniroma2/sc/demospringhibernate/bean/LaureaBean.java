package it.uniroma2.sc.demospringhibernate.bean;

import lombok.Data;

/**
 * This is a bean for the entity <code>Laurea</code>.
 * Attributes could be added/masked/modified... in order to send from/to client/server
 * only what we want it to see.
 */
@Data //Let Lombok manage getters, setters, and so on...
public class LaureaBean extends TitoloDiStudioBean{
    private boolean cicloUnico;

    protected LaureaBean() {
        super();
    }
    public LaureaBean(String nomeTitolo, int annoConseguimento, boolean cicloUnico) {
        super(nomeTitolo, annoConseguimento);
        this.cicloUnico = cicloUnico;
    }
}
