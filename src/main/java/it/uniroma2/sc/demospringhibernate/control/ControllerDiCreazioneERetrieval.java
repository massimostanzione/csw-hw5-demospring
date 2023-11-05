package it.uniroma2.sc.demospringhibernate.control;

import it.uniroma2.sc.demospringhibernate.bean.CaneBean;
import it.uniroma2.sc.demospringhibernate.bean.mapping.CaneMapper;
import it.uniroma2.sc.demospringhibernate.bean.mapping.DTOMapper;
import it.uniroma2.sc.demospringhibernate.dao.CaneDao;
import it.uniroma2.sc.demospringhibernate.dao.DiplomaDao;
import it.uniroma2.sc.demospringhibernate.dao.LaureaDao;
import it.uniroma2.sc.demospringhibernate.dao.PersonaDao;
import it.uniroma2.sc.demospringhibernate.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ControllerDiCreazioneERetrieval implements IControllerDiCreazioneERetrieval {

    @Autowired
    private CaneDao caneDao;

    @Autowired
    private DiplomaDao diplomaDao;

    @Autowired
    private LaureaDao laureaDao;

    @Autowired
    private PersonaDao personaDao;

    private CaneMapper mapper=new CaneMapper();
    @Transactional
    public void creazioniDiProva() {
        Indirizzo indirizzo = new Indirizzo("via e numero", "00100");
        Persona p = new Persona("nome", "cognome", indirizzo);

        Laurea l = new Laurea("nome titolo", 2010, false);
        Diploma d = new Diploma("nome titolo", 2010, "classe titolo");

        p.aggiungiTitolo(l);
        p.aggiungiTitolo(d);

        p = personaDao.save(p);

        //caneDao = new CaneDao();

        Cane c0 = new Cane("Bobby2", p);
        caneDao.save(c0);

        Cane c1 = new Cane("Bobby3", p);
        caneDao.save(c1);

        List<Cane> caniSalvati = caneDao.findAll();
        for (Cane c : caniSalvati) {
            System.out.println(c);
        }


        List<Cane> caniBobby = caneDao.findByNome("Bobby2");

        List<Cane> caniPerPadrone = caneDao.findByPadrone(p);

        List<Cane> caniPerCognomePadroneEsistente = caneDao.findByPadrone_CognomeLike("cogn%");
        List<Cane> caniPerCognomePadroneNonEsistente = caneDao.findByPadrone_CognomeLike("Bobby%");


    }
    /**
     * Issue #1
     * Oss.: gestione di EmptyResultDataAccessException se il record relativo non esiste
     *
     * @param idCane
     */
    @Override
    public void eliminaCane(@NotNull Long idCane) {
        caneDao.deleteById(idCane);
    }


    public CaneBean creaCane(@NotNull CaneBean c) {
        caneDao.save(this.mapper.toEntity(c));
        return c; // it is already a bean
    }

    public CaneBean leggiCanePerId(@NotNull Long idCane) {
      Cane  retrievedCane=caneDao.getOne(idCane);
       return this.mapper.toBean(retrievedCane);
    }

    public List<CaneBean> leggiCani() {
        List<Cane> retrievedCaneList = caneDao.findAll();
        return this.mapper.toBeanList(retrievedCaneList);
    }

    /**
     *
     * @param nome non deve essere null
     * @return
     */
    public List<CaneBean> cercaCaniPerNome(@NotNull String nome) {
        List<Cane> retrievedCaneList = caneDao.findByNome(nome);
        return this.mapper.toBeanList(retrievedCaneList);
    }

    public List<CaneBean> cercaCaniPerPadrone(@NotNull Long idPadrone) throws Exception {
        Persona padrone = personaDao.getOne(idPadrone); //TODO bean persona
        if(padrone==null) {
            throw new Exception("Nessun padrone presente con id " + idPadrone);
        }
        return this.mapper.toBeanList(caneDao.findByPadrone(padrone));
    }
}
