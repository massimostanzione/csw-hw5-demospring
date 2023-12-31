package it.uniroma2.sc.demospringhibernate.bean;

import it.uniroma2.sc.demospringhibernate.bean.mapping.Bean;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * This is a bean for the entity <code>Persona</code>.
 * Attributes could be added/masked/modified... in order to send from/to client/server
 * only what we want it to see.
 */
@Data //Let Lombok manage getters, setters, and so on...
public class PersonaBean  implements Bean {
    private Long id;
    private String nome;
    private String cognome;
    private IndirizzoBean indirizzo;
    private List<TitoloDiStudioBean> titoliDiStudio;
    private List<CaneBean> cani;
    private List<TitoloDiStudioBean> altriTitoliDiStudio;

    protected PersonaBean() {

    }

    public PersonaBean(String nome, String cognome, IndirizzoBean indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.titoliDiStudio = new LinkedList<>();
    }

    public void aggiungiTitolo(TitoloDiStudioBean titoloDiStudio) {
        titoliDiStudio.add(titoloDiStudio);
    }

}
