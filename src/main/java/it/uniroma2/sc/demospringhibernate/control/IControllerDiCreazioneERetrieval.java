package it.uniroma2.sc.demospringhibernate.control;
import it.uniroma2.sc.demospringhibernate.bean.CaneBean;
import it.uniroma2.sc.demospringhibernate.entity.Cane;

import java.util.List;

public interface IControllerDiCreazioneERetrieval {
    CaneBean creaCane(CaneBean c);

    CaneBean leggiCanePerId(Long idCane);

    List<CaneBean> leggiCani();

    List<CaneBean> cercaCaniPerNome(String nome);

    List<CaneBean> cercaCaniPerPadrone(Long idPadrone) throws Exception;

    void creazioniDiProva();

    /**
     * Issue #1
     * @param idCane
     */
    void eliminaCane(Long idCane);
}
