package it.uniroma2.sc.demospringhibernate.bean;

import it.uniroma2.sc.demospringhibernate.bean.mapping.Bean;
import lombok.Data;

/**
 * This is a bean for the entity <code>Citta</code>.
 * Attributes could be added/masked/modified... in order to send from/to client/server
 * only what we want it to see.
 */
@Data //Let Lombok manage getters, setters, and so on...
public class CittaBean  implements Bean {
    private String nome;
    private String codiceIstat;
    private String codiceCatastale;
}
