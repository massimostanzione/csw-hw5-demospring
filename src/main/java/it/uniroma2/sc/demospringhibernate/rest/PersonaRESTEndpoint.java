package it.uniroma2.sc.demospringhibernate.rest;

import it.uniroma2.sc.demospringhibernate.bean.PersonaBean;
import it.uniroma2.sc.demospringhibernate.control.IPersonaController;
import it.uniroma2.sc.demospringhibernate.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Issue #2
 */
@RestController
@RequestMapping("/persona/")
public class PersonaRESTEndpoint {
    @Autowired
    private IPersonaController ctrl;

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<PersonaBean> createPersona(@RequestBody(required = true) @NotNull PersonaBean p) {
        {
            if (p != null) { // TODO - is this check necessary?
                PersonaBean newPersona = ctrl.createPersona(p);
                ResponseEntity<PersonaBean> response = new ResponseEntity<>(newPersona, HttpStatus.CREATED);
                return response;
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "{idPersona}")
    public ResponseEntity<PersonaBean> readPersona(@PathVariable @NotNull Long idPersona) {
        PersonaBean p = ctrl.readPersonaById(idPersona);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "getAll")
    public ResponseEntity<List<PersonaBean>> readAllPersonas() {
        List<PersonaBean> l = ctrl.readAllPersonas();
        return new ResponseEntity<List<PersonaBean>>(l, HttpStatus.OK);
    }


    /*
     * "Update" CRUD function - link via REST POST handling (createPersona),
     * assuming update is implemented via "save" from CrudRepository intf. (-> JPA)
     */


    @RequestMapping(method = RequestMethod.GET, path = "delete/{idPersona}")
    public void deletePersonaById(@PathVariable @NotNull Long idPersona) {
        ctrl.deletePersonaById(idPersona);
    }

    /**
     * Oss.: ovviamente non è un @PathVariable
     *
     * @param p
     */
    @RequestMapping(method = RequestMethod.PUT, path = "delete")
    public void deletePersona(@RequestBody(required = true) @NotNull PersonaBean p) {
        ctrl.deletePersona(p);
    }
}