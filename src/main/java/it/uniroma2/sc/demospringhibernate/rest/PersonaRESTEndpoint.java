package it.uniroma2.sc.demospringhibernate.rest;

import it.uniroma2.sc.demospringhibernate.control.IPersonaController;
import it.uniroma2.sc.demospringhibernate.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * Issue #2
 */
@RestController
@RequestMapping("/persona/")
public class PersonaRESTEndpoint {
    @Autowired
    private IPersonaController ctrl;

    @RequestMapping(method = RequestMethod.POST, path = "")
    public ResponseEntity<Persona> createPersona(@RequestBody(required = true) @NotNull Persona p) {
        {
            if (p != null) { // is this check necessary?
                Persona newPersona = ctrl.createPersona(p);
                ResponseEntity<Persona> response = new ResponseEntity<>(newPersona, HttpStatus.CREATED);
                return response;
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "{idPersona}")
    public ResponseEntity<Persona> readPersona(@PathVariable @NotNull Long idPersona) {
        Persona p = ctrl.readPersonaById(idPersona);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }


    public ResponseEntity<Persona> updatePersona() {
        //TODO
        return null;
    }

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
    public void deletePersona(@RequestBody(required = true) @NotNull Persona p) {
        ctrl.deletePersona(p);
    }
}