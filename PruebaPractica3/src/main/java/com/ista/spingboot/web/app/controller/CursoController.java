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
import com.ista.spingboot.web.app.models.Curso;
import com.ista.spingboot.web.app.service.ICursoService;

@RestController
@RequestMapping("/api/Curso")
public class CursoController {
	
	@Autowired
    ICursoService cursoService;

    @GetMapping("/listarCurso")
    public ResponseEntity<List<Curso>> listarCurso() {
        return new ResponseEntity<>(cursoService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crearCurso")
    public ResponseEntity<Curso> crearCurso(
            @RequestBody Curso c) {
        return new ResponseEntity<>(cursoService.save(c),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizarCurso/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long id, @RequestBody Curso c) {
        Curso cursoAct = cursoService.findById(id);
        if (cursoAct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                cursoAct.setNivel(c.getNivel());
                cursoAct.setNombre(c.getNombre());
                cursoAct.setDescripcion(c.getDescripcion());
                return new ResponseEntity<>(cursoService.save(c), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminarCurso/{id}")
    public ResponseEntity<Curso> eliminarCurso(@PathVariable Long id) {
        cursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
