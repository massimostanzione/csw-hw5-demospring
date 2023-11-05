package it.uniroma2.sc.demospringhibernate.bean;

import it.uniroma2.sc.demospringhibernate.bean.mapping.Bean;
import lombok.Data;

/**
 * This is a bean for the entity <code>TitoloDiStudio</code>.
 * Attributes could be added/masked/modified... in order to send from/to client/server
 * only what we want it to see.
 */
@Data //Let Lombok manage getters, setters, and so on...
public abstract class TitoloDiStudioBean  implements Bean {
    private Long id;
    private String nomeTitolo;
    private int annoConseguimento;


    protected TitoloDiStudioBean() {

    }

    public TitoloDiStudioBean(String nomeTitolo, int annoConseguimento) {
        this.nomeTitolo = nomeTitolo;
        this.annoConseguimento = annoConseguimento;
    }
}
