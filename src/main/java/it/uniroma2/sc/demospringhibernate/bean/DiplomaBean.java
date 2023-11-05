package it.uniroma2.sc.demospringhibernate.bean;

import lombok.Data;

/**
 * This is a bean for the entity <code>Diploma</code>.
 * Attributes could be added/masked/modified... in order to send from/to client/server
 * only what we want it to see.
 */
@Data //Let Lombok manage getters, setters, and so on...
public class DiplomaBean extends TitoloDiStudioBean {
    private String classeDiploma;

    protected DiplomaBean() {
        super();
    }

    public DiplomaBean(String nomeTitolo, int annoConseguimento, String classeDiploma) {
        super(nomeTitolo, annoConseguimento);
        this.classeDiploma = classeDiploma;
    }
}
