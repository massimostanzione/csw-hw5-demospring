package it.uniroma2.sc.demospringhibernate.rest;

import it.uniroma2.sc.demospringhibernate.bean.CaneBean;
import it.uniroma2.sc.demospringhibernate.control.ControllerDiCreazioneERetrieval;
import it.uniroma2.sc.demospringhibernate.control.IControllerDiCreazioneERetrieval;
import it.uniroma2.sc.demospringhibernate.entity.Cane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cane/")
public class CaneRESTEndpoint {

    @Autowired
    private IControllerDiCreazioneERetrieval controllerDiCreazioneERetrieval;

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<?> creaCane(@RequestBody(required = true) CaneBean c) {
        if (c != null) {
            CaneBean newCane = controllerDiCreazioneERetrieval.creaCane(c);
            ResponseEntity<CaneBean> response = new ResponseEntity<>(newCane, HttpStatus.CREATED);
            return response;
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{idCane}")
    public ResponseEntity<?> leggiCane(@PathVariable Long idCane) {
        if (idCane != null) {
            CaneBean c = controllerDiCreazioneERetrieval.leggiCanePerId(idCane);
            if (c == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(c, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity<?> leggiCani() {
        List<CaneBean> tuttiICani = controllerDiCreazioneERetrieval.leggiCani();
        // mapping dto/entità e viceversa
        return new ResponseEntity<>(tuttiICani, HttpStatus.FOUND);
    }

    /*@RequestMapping(method = RequestMethod.GET, path = "")
    public List<Cane> leggiCani() {
        return controllerDiCreazioneERetrieval.leggiCani();
    }*/

    @RequestMapping(method = RequestMethod.GET, path = "search") // /api/cane/search?nomeCane=Bobby
    public ResponseEntity<?> cercaCaniPerNome(@RequestParam(name = "nomeCane", required = false) String nome) {
        if (nome != null) {
            return new ResponseEntity<>(controllerDiCreazioneERetrieval.cercaCaniPerNome(nome), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, path = "padrone/{id}")
    public ResponseEntity<?> cercaCaniPerPadrone(@PathVariable(name = "id") Long idPadrone) {
        try {
            return new ResponseEntity<>(controllerDiCreazioneERetrieval.cercaCaniPerPadrone(idPadrone), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "generate")
    public ResponseEntity<Void> generateSampleData() {
        controllerDiCreazioneERetrieval.creazioniDiProva();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Issue #1
     *
     * @param idCane
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "delete/{idCane}")
    public ResponseEntity<?> eliminaCane(@PathVariable(name = "idCane") Long idCane) {
        controllerDiCreazioneERetrieval.eliminaCane(idCane);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
