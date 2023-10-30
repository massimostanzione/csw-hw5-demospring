package it.uniroma2.sc.demospringhibernate.control;

import it.uniroma2.sc.demospringhibernate.entity.Cane;

import java.util.List;

public interface IControllerDiCreazioneERetrieval {
    Cane creaCane(Cane c);

    Cane leggiCanePerId(Long idCane);

    List<Cane> leggiCani();

    List<Cane> cercaCaniPerNome(String nome);

    List<Cane> cercaCaniPerPadrone(Long idPadrone) throws Exception;

    void creazioniDiProva();
}
