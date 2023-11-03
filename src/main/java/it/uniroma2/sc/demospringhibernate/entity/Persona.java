package it.uniroma2.sc.demospringhibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Persona {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String cognome;

    @OneToOne(cascade = CascadeType.ALL)
    private Indirizzo indirizzo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TitoloDiStudio> titoliDiStudio;

    /**
     * Oss.: Issue #2 - è stato necessario attributo "cascade" per reazione a delete di Persona
     */
    @OneToMany(mappedBy = "padrone", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cane> cani;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", name = "altri_titoli_id")
    private List<TitoloDiStudio> altriTitoliDiStudio;

    protected Persona() {

    }

    public Persona(String nome, String cognome, Indirizzo indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.titoliDiStudio = new LinkedList<>();
    }

    public void aggiungiTitolo(TitoloDiStudio titoloDiStudio) {
        titoliDiStudio.add(titoloDiStudio);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
