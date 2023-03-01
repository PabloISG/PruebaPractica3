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
import com.ista.spingboot.web.app.models.Depto;
import com.ista.spingboot.web.app.service.IDeptoService;

@RestController
@RequestMapping("/api/Depto")
public class DeptoController {

	@Autowired
	IDeptoService deptoService;

	@GetMapping("/listarDepto")
	public ResponseEntity<List<Depto>> listarDepto() {
		return new ResponseEntity<>(deptoService.findByAll(), HttpStatus.OK);
	}

	@PostMapping("/crearDepto")
	public ResponseEntity<Depto> crearDepto(@RequestBody Depto d) {
		return new ResponseEntity<>(deptoService.save(d), HttpStatus.CREATED);
	}

	@PutMapping("/actualizarDepto/{id}")
	public ResponseEntity<Depto> actualizarDepto(@PathVariable Long id, @RequestBody Depto d) {
		Depto dAct = deptoService.findById(id);
		if (dAct == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				dAct.setNombre(d.getNombre());
				dAct.setDirector(d.getDirector());
				return new ResponseEntity<>(deptoService.save(d), HttpStatus.OK);
			} catch (DataAccessException e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@DeleteMapping("/eliminarDepto/{id}")
	public ResponseEntity<Depto> eliminardepto(@PathVariable Long id) {
		deptoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
