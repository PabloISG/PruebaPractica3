package com.ista.spingboot.web.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ista.spingboot.web.app.models.Profesor;
import com.ista.spingboot.web.app.service.IProfesorService;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

	@Autowired
    IProfesorService iprofesorService;

    @GetMapping("/listarProf")
    public ResponseEntity<List<Profesor>> listarProf() {
        return new ResponseEntity<>(iprofesorService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crearProf")
    public ResponseEntity<Profesor> crearProf(
            @RequestBody Profesor p) {
        return new ResponseEntity<>(iprofesorService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizarProf/{id}")
    public ResponseEntity<Profesor> actualizarProf(@PathVariable Long id, @RequestBody Profesor p) {
        Profesor profAct = iprofesorService.findById(id);
        if (profAct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                profAct.setNombre(p.getNombre());
                profAct.setDireccion(p.getDireccion());
                profAct.setDireccion(p.getTelefono());
                return new ResponseEntity<>(iprofesorService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Profesor> eliminarProf(@PathVariable Long id) {
        iprofesorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
}
